package com.fag.raul;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/calculadora")
@Produces(MediaType.TEXT_HTML)
public class CalculadoraController {

    @Inject
    Template calculadoraPage;

    @Inject
    CalculadoraService calculadoraService;

    @GET
    public TemplateInstance calculadora() {
        return calculadoraPage.data("resultado", "").data("mensagemResultado", "");
    }

    @POST
    @Path("/calcular")
    public TemplateInstance calcular(@FormParam("num1") double num1, @FormParam("num2") double num2, @FormParam("operacao") String operacao) {
        double resultado = calculadoraService.realizarCalculo(num1, num2, operacao);
        String mensagemResultado = "";

        if (Double.isNaN(resultado)) {
            mensagemResultado = "Divisão por zero não é permitida.";
            resultado = 0; 
        }

        return calculadoraPage.data("resultado", String.format("%.10f", resultado))
                .data("mensagemResultado", mensagemResultado);
    }
}
