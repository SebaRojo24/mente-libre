package Servicio.simulado.de.chatbot.terapeutico.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatbotService {

    private static final Map<String, String> respuestas = new HashMap<>();

    static {
        respuestas.put("hola", "¡Hola! ¿Cómo te sientes hoy?");
        respuestas.put("me siento triste", "Lamento escuchar eso. Recuerda que está bien sentirse así. ¿Quieres hablar al respecto?");
        respuestas.put("me siento bien", "¡Qué bueno! Me alegra saberlo. 😊");
        respuestas.put("ayuda", "Estoy aquí para escucharte. Puedes contarme cómo te sientes.");
    }

    public String responder(String mensaje) {
        String mensajeLimpio = mensaje.toLowerCase().trim();
        return respuestas.getOrDefault(mensajeLimpio, "Lo siento, aún no entiendo ese mensaje. ¿Puedes reformularlo?");
    }
}
