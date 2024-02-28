package hw3.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import hw3.exceptions.InputException;

public class CheckPerson {

    public String checking (String data) throws InputException {
        String[] splittedData = data.replaceAll("\\s+", " ").split(" ");
        if (splittedData.length < 6) throw new InputException("Вы ввели не все данные либо забыли пробел.");
        if (splittedData.length > 6) throw new InputException("Вы ввели лишние данные или поставили лишний пробел.");

        try { checkDate(splittedData[3]); } 
        catch (ParseException e) { throw new InputException("Вы неверно ввели дату рождения. Дата рождения должна быть в формате  dd.mm.yyyy"); }
        
        try { checkPhoneNumber(splittedData[4]); }
        catch (NumberFormatException | ParseException e) { throw new InputException("Вы неверно ввели номер телефона."); }

        try { checkSexChar(splittedData[5]); }
        catch (ArrayIndexOutOfBoundsException | InputException e) { throw new InputException("Вы неверно ввели пол."); }

        return splittedData[0];
    }

    private void checkDate(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy"); 
        df.parse(date);
    }

    private void checkPhoneNumber(String phoneNumber) throws NumberFormatException, ParseException {
        Long.parseLong(phoneNumber);
    }

    private void checkSexChar(String sex) throws ArrayIndexOutOfBoundsException, InputException {
        char[] ch = sex.replace(" ", "").toCharArray();
        if (ch.length > 1 || (ch[0] != 'f' && ch[0] != 'm')) throw new InputException();
    }
}
// фамилия имя отчество 36.52.2069 79116532315 f