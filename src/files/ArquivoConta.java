package files;
import accounts.*;

import java.io.*;
import java.util.Vector;

public class ArquivoConta implements IAccountRepo {
    private String nomeArquivo;
    public ArquivoConta(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }
    @Override
    public void insert(AbstractAccount account) {
        try{
            FileWriter fWriter = new FileWriter(nomeArquivo, true);
            PrintWriter pWriter = new PrintWriter(fWriter);
            String linha = "";

            if(account instanceof Account) linha = "COMMON;" + account.getId() + ";" + account.getBalance();
            if(account instanceof SavingsAccount) linha = "SAVINGS;" + account.getId() + ";" + account.getBalance();
            if(account instanceof EspecialAccount) linha = "SPECIAL;" + account.getId() + ";" + account.getBalance() + ((EspecialAccount) account).getBonus();
            if(account instanceof TaxAccount) linha = "TAX;" + account.getId() + ";" + account.getBalance();

            pWriter.println(linha);
            pWriter.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(String id) {
        Vector<String> linhasRestantes = new Vector<String>();
        try{
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while((linha = leitor.readLine()) != null){
                String[] dados = linha.split(";");

                if(!dados[1].equals(id)){
                    linhasRestantes.add(linha);
                }
            }
            leitor.close();
            PrintWriter gravador = new PrintWriter(new FileWriter(nomeArquivo, false));
            for(String l : linhasRestantes){
                gravador.println(l);
            }
            gravador.close();

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public AbstractAccount search(String id) {
        AbstractAccount a = null;
        try{
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while((linha = leitor.readLine())!=null){
                String[] data = linha.split(";");
                if(data[1].equals(id)){
                    String type = data[0];
                    double savedBalance = Double.parseDouble(data[2]);
                    switch (type) {
                        case "COMMON" -> {
                            a = new Account(id);
                            a.credit(savedBalance);
                        }
                        case "SAVINGS" -> {
                            a = new SavingsAccount(id);
                            a.credit(savedBalance);
                        }
                        case "SPECIAL" -> {
                            a = new EspecialAccount(id);
                            double savedBonus = Double.parseDouble(data[3]);
                            ((EspecialAccount) a).setBonus(savedBonus);
                            a.credit(savedBalance);
                        }
                        default -> {
                            a = new TaxAccount(id);
                            a.credit(savedBalance);
                        }
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public AbstractAccount[] listt() {
        int s = sizee();
        AbstractAccount[] array = new AbstractAccount[s];
        int i = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            String line;
            while((line = reader.readLine())!=null){
                String[] data = line.split(";");
                AbstractAccount a = search(data[1]);
                array[i] = a;
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return array;
    }

    @Override
    public int sizee() {
        int cont = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while((linha = reader.readLine())!=null){
                cont++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return cont;
    }
}
