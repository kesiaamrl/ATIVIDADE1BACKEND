import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Pokemon {
  private  String nome;
  private  LocalDate data;
  private  int pc;
DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public Pokemon (String nome, LocalDate data, int pc){
    this.data=data;
    this.nome=nome;
    this.pc=pc;
  }
    
  
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public LocalDate getData() {
    return data;
}
public void setData(LocalDate data) {
    this.data = data;
}
public int getPc() {
    return pc;
}
public void setPc(int pc) {
    this.pc = pc;
}

@Override
public String toString() {
    return "[Nome do Pokemon: " + nome + " | Data de encontro: " + data.format(formato) + " | Pontos de combate: " + pc + "]";

}
}
