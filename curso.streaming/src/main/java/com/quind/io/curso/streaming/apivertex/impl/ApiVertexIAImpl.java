package com.quind.io.curso.streaming.apivertex.impl;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import com.quind.io.curso.streaming.apivertex.ApiVertexInterface;
import com.quind.io.curso.streaming.model.EventCustomer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ApiVertexIAImpl implements ApiVertexInterface {

        String PROJECT_ID = "annular-garage-440504-n9";
        String LOCATION = "us-central1";
        String MODEL_NAME = "gemini-1.5-flash-001";


        @Override
        public  List<String> consumeModelIa(EventCustomer eventCustomer) throws IOException {
            List<String> result = new ArrayList<>();

            String TEXT_PROMPT_BASE =
                    "Actúa como un motor de recomendaciones para una tienda de calazado online, "
                            + "quiero que me des recomendaciones acerca de nombres de zapatos para "
                            + "un cliente con las siguientes especificaciones, nombre" + eventCustomer.getCustomer().getName()
                            + " edad: " + eventCustomer.getCustomer().getAge()
                            + "Genero: " + eventCustomer.getCustomer().getGender()
                            + "Ubicación: " + eventCustomer.getCustomer().getLocation()
                            + "La tienda de zapatos se encuentra ubicada en Medellín, y "
                            + "el evento que está generando el usuario dentro de la tienda, es:"
                            + eventCustomer.getEvent() + "Quiero que me entregues únicamente " +
                            "unformación acerca de los nombres de los zapatos que le podría recomendar " +
                            "a este usuario, según la información que te suministré, entregame los nombres " +
                            "separados por coma, para poder agregarlos en una lista de Java, entonces por favor solo entregame los nombres";

            result.addAll(Arrays.stream(textInput(PROJECT_ID, LOCATION, MODEL_NAME, TEXT_PROMPT_BASE)).toList());
            return result;
        }

        // Passes the provided text input to the Gemini model and returns the text-only response.
        // For the specified textPrompt, the model returns a list of possible store names.
        public String[] textInput(String projectId, String location, String modelName, String textPrompt) throws IOException {
            // Initialize client that will be used to send requests. This client only needs
            // to be created once, and can be reused for multiple requests.
            try (VertexAI vertexAI = new VertexAI(projectId, location)) {
                GenerativeModel model = new GenerativeModel(modelName, vertexAI);
                GenerateContentResponse response = model.generateContent(textPrompt);
                String output = ResponseHandler.getText(response);
                return output.split(",");
            }
        }


}
