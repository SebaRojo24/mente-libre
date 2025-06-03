package Servicio.simulado.de.chatbot.terapeutico.controller;

import Servicio.simulado.de.chatbot.terapeutico.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @PostMapping("/mensaje")
    public Map<String, String> responder(@RequestBody String mensaje) {
        String respuesta = chatbotService.responder(mensaje);
        return Map.of("mensaje", respuesta);
    }

    @GetMapping("/sugerencias")
    public Map<String, String[]> sugerencias() {
        return Map.of("sugerencias", new String[] {
                "hola",
                "me siento triste",
                "me siento bien",
                "ayuda"
        });
    }
}
