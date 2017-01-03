package pmd.di.ubi.pt.titcherspet;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Artur on 03/01/2017.
 */

public class Alunos {
    @SerializedName("N_Aluno")

    public int N_Aluno;
    @SerializedName("Nome")

    public String Nome;
    @SerializedName("Email")

    public String Email_E;
    @SerializedName("Data_Nascimento")

    public String Data_Nascimento;

    @SerializedName("Sexo")
    public String Sexo;
}
