package domainHelper;

/**
 * Har valt att skapa en klass med statiska metoder för att kontrollera och formatera en sträng enligt formatet
 * Aaaaa Bbbbb, inte jättebra implementation men mer ett exempel på single responsibility principle.
 * @author Emil Lindström Moffatt
 * @Version 2025-01-27
 */

public class NameFormatter {

    /**
     *Dålig metod som försöker formatera ett ord utan tillräckligt med felkontroller men men
     * den får duga för nu xD
     *
     * @param name namn att formattera
     * @return formatterat namn
     * @throws IllegalArgumentException om namnet är fel
     */
    public static String formatName(String name) {
        if (!checkName(name)) {
            throw new IllegalArgumentException("Illegal name format");
        }

        //TODO kolla ännu fler buggar, behövs massor här ngl. Lite osäker på hur det ska implementeras på ett bra sätt.
        //IDK if i can do this xDDDDD

        String[] words = name.split(" ");

        StringBuilder formattedName = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                formattedName.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return formattedName.toString().trim();
    }

    /**
     * Kollar att namnet är någolunda korrekt
     *
     * @param name namn att kontrollera
     * @return sant om namnet är korrekt, annars falskt.
     */
    private static boolean checkName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        String regex = "^[\\p{L} ]+$";
        return name.matches(regex) && name.length() >= 3 && name.length() <= 45;
    }
}
