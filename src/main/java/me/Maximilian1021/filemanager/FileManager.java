package me.Maximilian1021.filemanager;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {
    public static void createLangFile() {
        File file = new File("plugins/SimplePlugins", "SimpleFlyLang.yml");
        YamlConfiguration LangFly = YamlConfiguration.loadConfiguration((File)file);
        if (!file.exists()) {
            LangFly.set("Language", "German");
            LangFly.set("German.Prefix", "§f[§bFly§f]");
            LangFly.set("German.NoPerm", " §cDu hast nicht genügend Permission");
            LangFly.set("German.NoPlayer", " §cDu musst ein Spieler sein um den Command auszuführen");
            LangFly.set("German.NotOn", " §cDieser Speieler ist nicht online!");
            LangFly.set("German.FLYON", " §bDein Flugmodus wurde §aaktiviert");
            LangFly.set("German.FLYOFF", " §bDein Flugmodus wurde §cdeaktiviert");
            LangFly.set("German.Usage", " §cbBitte benutze a/fly <Name>b!");

            LangFly.set("English.Prefix", "§f[§bFly§f]");
            LangFly.set("English.NoPerm", " §cYou don't have the permission to do this!");
            LangFly.set("English.NoPlayer", " §cYou have to be a player to use this command!");
            LangFly.set("English.NotOn", " §cThe selected Player isn´t online!");
            LangFly.set("English.FLYON", " §bYour Flightmode has been §aenabled");
            LangFly.set("English.FLYOFF", " §bYour Flightmode has been §cdisabled");
            LangFly.set("English.Usage", " §cUsage: a/fly <name>b!");
        }
        try {
            LangFly.save(file);
        }
        catch (IOException e) {
            System.out.println("Fehler in der Configuration SimpleFlyLang.yml");
            e.printStackTrace();
        }
    }

    public static File getSFlyLangFile() {
        return new File("plugins/SimplePlugins", "SimpleFlyLang.yml");
    }
}

