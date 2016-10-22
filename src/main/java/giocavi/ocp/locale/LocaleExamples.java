package giocavi.ocp.locale;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Giovanni on 06/10/2016.
 */
public class LocaleExamples {
    public static void main(String[] args) throws ParseException {
        Locale loc = Locale.UK;
        //Locale.setDefault(Locale.ITALIAN);
        ResourceBundle rb = ResourceBundle.getBundle("Gio");
        System.out.println(rb.getString("ciao"));
        NumberFormat pounds = NumberFormat.getCurrencyInstance(loc);
        System.out.println(pounds.format(100));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.FRANCE).format(100));
        System.out.println(NumberFormat.getInstance(Locale.FRANCE).format(100.30));
        System.out.println(NumberFormat.getPercentInstance(Locale.UK).format(0.1));
        System.out.println(NumberFormat.getPercentInstance(Locale.UK).parse("10%uuuuu"));


    }
}
