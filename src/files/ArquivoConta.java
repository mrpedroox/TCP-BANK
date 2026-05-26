package files;
import accounts.*;

import java.io.*;
import java.util.Vector;

public class ArquivoConta implements IAccountRepo {
    private String nomeArquivo = "contas.txt";
    @Override
    public void insert(AbstractAccount account) {
        try{
            FileWriter fWriter = new FileWriter(nomeArquivo, true);
            PrintWriter pWriter = new PrintWriter(fWriter);
            String linha = "";

            if(account instanceof Account) linha = "COMUM;" + account.getId() + ";" + account.getBalance();
            if(account instanceof SavingsAccount) linha = "POUPANCA;" + account.getId() + ";" + account.getBalance();
            if(account instanceof EspecialAccount) linha = "ESPECIAL;" + account.getId() + ";" + account.getBalance() + ((EspecialAccount) account).getBonus();
            if(account instanceof TaxAccount) linha = "IMPOSTO;" + account.getId() + ";" + account.getBalance();

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
        return null;
    }

    @Override
    public AbstractAccount[] listt() {
        return new AbstractAccount[0];
    }

    @Override
    public int sizee() {
        return 0;
    }
}
