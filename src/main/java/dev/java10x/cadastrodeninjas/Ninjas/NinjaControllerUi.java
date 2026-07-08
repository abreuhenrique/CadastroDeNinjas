package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas (Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

    @GetMapping("/listar/{id}")
    public String listarId(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjasId(id);

        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesNinja";
        } else {
            model.addAttribute("mensagem", "Ninja não foi encontrado.");
            return "listarNinjas";
        }

    }

    @GetMapping("/adicionar")
    public String adicionarNinja(Model model){
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarNInjas(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
        return "redirect:/ninjas/ui/listar";
    }
}
