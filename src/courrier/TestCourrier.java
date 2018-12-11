package courrier;

interface Contenu {
    void encode(String texte);
    String toString();
}

class ContenuTexte implements Contenu {
    protected String texte;
    public void encode(String texte)
    {
        this.texte = texte;
    }
    public String toString()
    {
        return (texte);
    }
}
class ContenuHtml implements Contenu {
    protected String codeHtml;
    public void encode(String texte)
    {
        codeHtml = "<HTML>" + texte + "</HTML>";
    }
    public String toString()
    {
        return (codeHtml);
    }
}

class Courrier<T extends Contenu> {
    protected T contenu;
    protected String destinataire;

    public Courrier(Class<T> instance) {
        super();
        try {
            contenu = instance.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void prepare(String destinataire, String texte)
    {
        this.destinataire = destinataire;
        contenu.encode(texte);
    }
    public String toString()
    {
        String st = "destinataire : " + destinataire + "\n";
        st += "contenu : " + contenu.toString();
        return st;
    }
}

public class TestCourrier {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException
    {
        Courrier<ContenuHtml> courrierHtml = new Courrier<ContenuHtml>(ContenuHtml.class);
        courrierHtml.prepare("adresse1@domaine", "texte1");
        Courrier<ContenuTexte> courrierTexte = new Courrier<ContenuTexte>(ContenuTexte.class);
        courrierTexte.prepare("adresse2@domaine", "texte2");
        System.out.println(courrierTexte);
    }

}