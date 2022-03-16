import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public class Examen {

public static void main(String[] args) {

            /*
            Creación del Bot y su respectivo token:

            1. Primeramente, vamos al portal de desarrolladores de Discord.
            2. Iniciamos Sesion.
            3. Creamos una nueva aplicación de Discord
            4. Una vez creada, dentro de la app, generamos un nuevo Bot de Discord, accediendo
               al menu de la izquierda y clickando en "Bot" y posteriormente en "Create Bot".
            5.En la pagina de editar el bot le damos a Generar Token. Ya tenemos el token.

            El codigo, lo que hace, es tomar un token generado por el bot previamente creado y
            mostrar un mensaje de Pong! cuando le escribamos ¡ping.
            El token generado lo metemos en la variable token para que funcione.
             */
            final String token = args[0];
            final DiscordClient client = DiscordClient.create(token);
            final GatewayDiscordClient gateway = client.login().block();

            gateway.on(MessageCreateEvent.class).subscribe(event -> {
                final Message message = event.getMessage();
                if ("!ping".equals(message.getContent())) {
                    final MessageChannel channel = message.getChannel().block();
                    channel.createMessage("Pong!").block();
                }
            });

            gateway.onDisconnect().block();
        }
    }


