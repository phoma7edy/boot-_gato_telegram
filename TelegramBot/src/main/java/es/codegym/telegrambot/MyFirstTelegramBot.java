package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.crypto.Mac;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "poma2377Bot_bot";
    public static final String TOKEN = "7142018706:AAHU0BxuS4-r4zpTBE1rBz3dPEgLID2ZoEY";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if(getMessageText().equals("/start")){
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Hackear la nevera","step_1_btn"));

        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("¡tomar una salchicha!","step_2_btn",
                            "¡tomar una pescado!","step_2_btn",
                            "¡tomar una chicharon!","step_2_btn",
                            "¡tomar una lechita!","step_2_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("¡Romper al robot aspiradora!","step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("¡Enviar al roboot a por comida!","step_4_btn",
                            "¡Pasear encima del robot!","step_4_btn",
                            "¡Hacerlo tu asisitente personal!","step_4_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("¡ponerse y encender!","step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(40);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("¡jugar con pelota!","step_6_btn",
                            "¡comer pescatito!","step_6_btn",
                            "¡hecharte una ciesta!","step_6_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_6_btn")){
            setUserGlory(40);
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackear la computadora","step_7_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(50);
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("¡ganamos!","step_8_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")){
            setUserGlory(0);
            sendTextMessageAsync(FINAL_TEXT,
                    Map.of("¡Volver!","step_9_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_9_btn")){
            setUserGlory(0);
            sendTextMessageAsync(FIN,
                    Map.of("¡GANAMOS!","step_1_btn"));
        }

        /* else if(getMessageText().toLowerCase().contains("hola")){
            sendTextMessageAsync("*hola* como te llamas ");
        } else if(getMessageText().toLowerCase().contains("mi nombre es") || getMessageText().toLowerCase().contains("me llamo")){
            sendTextMessageAsync("Encantado de conocerte, soy *Gato*");
            sendTextMessageAsync("que tecnologias te gustaria aprender");
        } else if(getMessageText().toLowerCase().contains("me gustaria aprender") || getMessageText().toLowerCase().contains("quiero aprender")){
            sendTextMessageAsync("_excelente_");
            sendTextMessageAsync("hay nucho por aprender de java");
        }*/


        //sendTextMessageAsync("como podemos *ayudarte*!");



    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}