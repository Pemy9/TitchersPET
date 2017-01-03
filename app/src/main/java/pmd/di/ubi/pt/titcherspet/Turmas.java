package pmd.di.ubi.pt.titcherspet;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Artur on 01/01/2017.
 */

public class Turmas {

    @SerializedName("N_Turma")
    public String N_Turma;

    @SerializedName("Email")
    public String Email;

    @SerializedName("N_Aluno")
    public int N_Aluno;

    @SerializedName("Sala")
    public String Sala;
}
