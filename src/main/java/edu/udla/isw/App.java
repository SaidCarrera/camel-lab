package edu.udla.isw;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App extends RouteBuilder {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new App());
        main.run(args);
    }

    @Override
    public void configure() {
        from("file:input?noop=false&include=.*\\.csv")
            .routeId("route1")
            .convertBodyTo(String.class) // ✅ Convierte el archivo en texto
            .log("Procesando archivo: ${file:name}")
            .transform().simple("${body.toUpperCase()}") // ✅ Convierte el contenido a mayúsculas
            .to("file:output")
            .log("Archivo ${file:name} transformado y movido a output.")
            .to("file:archived")
            .process(exchange -> {
                String archivo = exchange.getIn().getHeader("CamelFileName", String.class);
                String timestamp = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                System.out.println("[" + timestamp + "] Archivo " + archivo + " procesado y archivado correctamente.");
            });
    }
}
