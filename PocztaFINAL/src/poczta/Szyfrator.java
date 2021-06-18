package poczta;

public class Szyfrator {
    private char [] kl;
    private int z=0;
    private int we=2;

    public Szyfrator(String klucz){
        kl = klucz.toCharArray();
    }

    public void szyfruj(Wiadomosc wiadomosc){
        if (wiadomosc.getPolecenie() != null) wiadomosc.setPolecenie(szyfruj(wiadomosc.getPolecenie()));
        if (wiadomosc.getOdbiorca() != null) wiadomosc.setOdbiorca(szyfruj(wiadomosc.getOdbiorca()));
        if (wiadomosc.getTemat() != null) wiadomosc.setTemat(szyfruj(wiadomosc.getTemat()));
        if (wiadomosc.getTekst() != null) wiadomosc.setTekst(szyfruj(wiadomosc.getTekst()));

    }
    public void odszyfruj(Wiadomosc wiadomosc){
        if (wiadomosc.getPolecenie() != null) wiadomosc.setPolecenie(odszyfruj(wiadomosc.getPolecenie()));
        if (wiadomosc.getOdbiorca() != null) wiadomosc.setOdbiorca(odszyfruj(wiadomosc.getOdbiorca()));
        if (wiadomosc.getTemat() != null) wiadomosc.setTemat(odszyfruj(wiadomosc.getTemat()));
        if (wiadomosc.getTekst() != null) wiadomosc.setTekst(odszyfruj(wiadomosc.getTekst()));

    }
    public void szyfruj(Konto konto){
        if (konto.getNazwa() != null) konto.setNazwa(szyfruj(konto.getNazwa()));
        if (konto.getNazwisko() != null) konto.setNazwisko(szyfruj(konto.getNazwisko()));
        if (konto.getHaslo() != null) konto.setHaslo(szyfruj(konto.getHaslo()));
        if (konto.getKluczSzyfrowania() != null) konto.setKluczSzyfrowania(szyfruj(konto.getKluczSzyfrowania()));
        if (konto.getEmailZapasowy() != null) konto.setEmailZapasowy(szyfruj(konto.getEmailZapasowy()));
        if (konto.getEmail() != null) konto.setEmail(szyfruj(konto.getEmail()));
        if (konto.getPolecenie() != null) konto.setPolecenie(szyfruj(konto.getPolecenie()));

    }
    public void odszyfruj(Konto konto){
        if (konto.getNazwa() != null) konto.setNazwa(odszyfruj(konto.getNazwa()));
        if (konto.getNazwisko() != null) konto.setNazwisko(odszyfruj(konto.getNazwisko()));
        if (konto.getHaslo() != null) konto.setHaslo(odszyfruj(konto.getHaslo()));
        if (konto.getKluczSzyfrowania() != null) konto.setKluczSzyfrowania(odszyfruj(konto.getKluczSzyfrowania()));
        if (konto.getEmailZapasowy() != null) konto.setEmailZapasowy(odszyfruj(konto.getEmailZapasowy()));
        if (konto.getEmail() != null) konto.setEmail(odszyfruj(konto.getEmail()));
        if (konto.getPolecenie() != null) konto.setPolecenie(odszyfruj(konto.getPolecenie()));

    }
    public void szyfruj(ListaWiadomosci listaWiadomosci){
        for(Wiadomosc wiadomosc: listaWiadomosci.getLista()) szyfruj(wiadomosc);
    }
    public void odszyfruj(ListaWiadomosci listaWiadomosci){
        for(Wiadomosc wiadomosc: listaWiadomosci.getLista()) odszyfruj(wiadomosc);
    }

    public String szyfruj(String txtString){
        char [] txt_jw = txtString.toCharArray();
        int rozmiar = txt_jw.length;
        int [] wart_kl = klucz(kl);
        int [] wart_kl_kopia = new int[wart_kl[0]];

        for(int i=0;i<wart_kl[0];i++)
            wart_kl_kopia[i]=wart_kl[i];

        cezar(txt_jw,rozmiar,wart_kl);
        odwrot(txt_jw);

        char [] matryca = matryca_tworzenie(wart_kl_kopia);
        matryca_szyfr(txt_jw,rozmiar,matryca);

        z = 0;
        we = 2;
        return new String(txt_jw);
    }
    public String odszyfruj(String txtString){
        char [] txt_jw = txtString.toCharArray();
        int rozmiar = txt_jw.length;
        int [] wart_kl = klucz(kl);
        int [] wart_kl_kopia = new int[wart_kl[0]];

        for(int i=0;i<wart_kl[0];i++)
            wart_kl_kopia[i]=wart_kl[i];

        char [] matryca = matryca_tworzenie(wart_kl_kopia);
        matryca_odszyfr(txt_jw,rozmiar,matryca);

        odwrot(txt_jw);
        z=0;
        fhcdu(txt_jw,rozmiar,wart_kl);

        z = 0;
        we = 2;
        return new String(txt_jw);
    }
    private int [] klucz(char[] klucz) {
        int [] wart_kl = new int[klucz.length+1];
        wart_kl[0]=klucz.length;
        for(int i=0;i<wart_kl[0];i++)
            wart_kl[i+1]=(int)klucz[i];
        return wart_kl;
    }
    private void cezar(char a[],int rozmiar,int wart_kl[]) {

        int kod;
        int d;
        for(int i=0;i<rozmiar;i++)
        {
            kod=(int)a[i];
            d = czyDuza(a[i]);
            if(kod==32)
                z=0;
            if(kod<=122 - d && kod>=97 - d)
            {
                if(we%2==0)
                {
                    kod=kod+generator(wart_kl);
                    we++;
                }
                if(we%2==1)
                {
                    kod=kod+generator2(wart_kl);
                    we++;
                }
                if(kod > 122 - d)
                    kod=kod-26;
                if(kod > 122 - d)
                    kod=kod-26;
                a[i]=(char)kod;
            }
        }
    }
    private void fhcdu(char a[],int rozmiar,int wart_kl[])
    {
        int kod;
        int d;
        for(int i=0;i<rozmiar;i++)
        {
            kod=(int)a[i];
            d = czyDuza(a[i]);
            if(kod==32)
                z=0;
            if(kod <= 122 - d && kod >= 97 - d)
            {
                if(we%2==0)
                {
                    kod=kod-generator(wart_kl);
                    we++;
                }
                if(we%2==1)
                {
                    kod=kod-generator2(wart_kl);
                    we++;
                }
                if(kod<97 - d)
                    kod=kod+26;
                if(kod<97 - d)
                    kod=kod+26;
                a[i]=(char)kod;
            }
        }
    }
    private int generator(int wart_kl[]) {
        int x,y;
        if(z==0)
        {
            x=wart_kl[1]+wart_kl[3];
            y=(wart_kl[2]*wart_kl[4])+wart_kl[0];
            x=x*x;
            y=(y+45)%wart_kl[0];
            x=y-(x-wart_kl[6]);
            x=x%25;
            z++;
        }
        else
        {
            wart_kl[1]=wart_kl[2]+wart_kl[3];
            wart_kl[2]=wart_kl[1]-50;
            wart_kl[3]=wart_kl[4]-wart_kl[3];
            wart_kl[4]=(wart_kl[4]+wart_kl[1])%101;
            x=wart_kl[1]+wart_kl[3];
            y=(wart_kl[2]*wart_kl[4])+wart_kl[0];
            x=x*x;
            y=(y+45)%wart_kl[0];
            x=y-(x-wart_kl[6]);
            x=x%25;
        }
        return Math.abs(x);
    }
    private int generator2(int wart_kl[]) {
        int x = wart_kl[0];

        if(x%2==0 || x==0)
            for(int i=1;i<wart_kl[0];i++)
                x=x+wart_kl[i]+1;

        if(x%3==0)
            for(int i=1;i<wart_kl[0];i++)
                x=x-wart_kl[i]-7;

        if(x%5==0)
            for(int i=1;i<wart_kl[0];i++)
                x=x+wart_kl[i]-wart_kl[i-1]+2;

        x=x%5;

        return Math.abs(x);

    }
    private void odwrot(char a[]) {
        for(int i = 0; i < a.length / 2; i++)
        {
            char temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }
    private char[] matryca_tworzenie(int wart_kl[]) {
        char matryca[]={ 'f', 'm', 'e', 'h', 'r', 's','y','d','i','w','x','u','c','q','b','n','z','k','l','v','o','j','g','t','a','p','\0' };

        int k;
        char pomoc;
        for(int i=1;i<wart_kl[0];i++)
        {
            for(int j=0;j<27;j++)
            {
                if(wart_kl[i]==(int)matryca[j])
                {
                    k=j+generator2(wart_kl);
                    if(k>25)
                    {
                        k=k-j;
                        pomoc=matryca[j];//zamien
                        matryca[j]=matryca[k];
                        matryca[k]=pomoc;
                    }
                    else
                    {
                        pomoc=matryca[j];//zamien
                        matryca[j]=matryca[k];
                        matryca[k]=pomoc;
                    }
                }
            }
        }
        return matryca;

    }
    private void matryca_szyfr(char a[],int rozmiar,char matryca[]) {
        int d;
        for(int i=0;i<rozmiar;i++) {
            d = czyDuza(a[i]);
            if((int)a[i]==(97-d))a[i]=(char)((int)matryca[0]-d);else
            if((int)a[i]==(98-d))a[i]=(char)((int)matryca[1]-d);else
            if((int)a[i]==(99-d))a[i]=(char)((int)matryca[2]-d);else
            if((int)a[i]==(100-d))a[i]=(char)((int)matryca[3]-d);else
            if((int)a[i]==(101-d))a[i]=(char)((int)matryca[4]-d);else
            if((int)a[i]==(102-d))a[i]=(char)((int)matryca[5]-d);else
            if((int)a[i]==(103-d))a[i]=(char)((int)matryca[6]-d);else
            if((int)a[i]==(104-d))a[i]=(char)((int)matryca[7]-d);else
            if((int)a[i]==(105-d))a[i]=(char)((int)matryca[8]-d);else
            if((int)a[i]==(106-d))a[i]=(char)((int)matryca[9]-d);else
            if((int)a[i]==(107-d))a[i]=(char)((int)matryca[10]-d);else
            if((int)a[i]==(108-d))a[i]=(char)((int)matryca[11]-d);else
            if((int)a[i]==(109-d))a[i]=(char)((int)matryca[12]-d);else
            if((int)a[i]==(110-d))a[i]=(char)((int)matryca[13]-d);else
            if((int)a[i]==(111-d))a[i]=(char)((int)matryca[14]-d);else
            if((int)a[i]==(112-d))a[i]=(char)((int)matryca[15]-d);else
            if((int)a[i]==(113-d))a[i]=(char)((int)matryca[16]-d);else
            if((int)a[i]==(114-d))a[i]=(char)((int)matryca[17]-d);else
            if((int)a[i]==(115-d))a[i]=(char)((int)matryca[18]-d);else
            if((int)a[i]==(116-d))a[i]=(char)((int)matryca[19]-d);else
            if((int)a[i]==(117-d))a[i]=(char)((int)matryca[20]-d);else
            if((int)a[i]==(118-d))a[i]=(char)((int)matryca[21]-d);else
            if((int)a[i]==(119-d))a[i]=(char)((int)matryca[22]-d);else
            if((int)a[i]==(120-d))a[i]=(char)((int)matryca[23]-d);else
            if((int)a[i]==(121-d))a[i]=(char)((int)matryca[24]-d);else
            if((int)a[i]==(122-d))a[i]=(char)((int)matryca[25]-d);else;
        }
    }
    private void matryca_odszyfr(char a[],int rozmiar,char matryca[]) {
        int d;
        for(int i=0;i<rozmiar;i++)
        {
            d = czyDuza(a[i]);
            if((int)a[i]==((int)matryca[0]-d))a[i]=(char)(97-d);else
            if((int)a[i]==((int)matryca[1]-d))a[i]=(char)(98-d);else
            if((int)a[i]==((int)matryca[2]-d))a[i]=(char)(99-d);else
            if((int)a[i]==((int)matryca[3]-d))a[i]=(char)(100-d);else
            if((int)a[i]==((int)matryca[4]-d))a[i]=(char)(101-d);else
            if((int)a[i]==((int)matryca[5]-d))a[i]=(char)(102-d);else
            if((int)a[i]==((int)matryca[6]-d))a[i]=(char)(103-d);else
            if((int)a[i]==((int)matryca[7]-d))a[i]=(char)(104-d);else
            if((int)a[i]==((int)matryca[8]-d))a[i]=(char)(105-d);else
            if((int)a[i]==((int)matryca[9]-d))a[i]=(char)(106-d);else
            if((int)a[i]==((int)matryca[10]-d))a[i]=(char)(107-d);else
            if((int)a[i]==((int)matryca[11]-d))a[i]=(char)(108-d);else
            if((int)a[i]==((int)matryca[12]-d))a[i]=(char)(109-d);else
            if((int)a[i]==((int)matryca[13]-d))a[i]=(char)(110-d);else
            if((int)a[i]==((int)matryca[14]-d))a[i]=(char)(111-d);else
            if((int)a[i]==((int)matryca[15]-d))a[i]=(char)(112-d);else
            if((int)a[i]==((int)matryca[16]-d))a[i]=(char)(113-d);else
            if((int)a[i]==((int)matryca[17]-d))a[i]=(char)(114-d);else
            if((int)a[i]==((int)matryca[18]-d))a[i]=(char)(115-d);else
            if((int)a[i]==((int)matryca[19]-d))a[i]=(char)(116-d);else
            if((int)a[i]==((int)matryca[20]-d))a[i]=(char)(117-d);else
            if((int)a[i]==((int)matryca[21]-d))a[i]=(char)(118-d);else
            if((int)a[i]==((int)matryca[22]-d))a[i]=(char)(119-d);else
            if((int)a[i]==((int)matryca[23]-d))a[i]=(char)(120-d);else
            if((int)a[i]==((int)matryca[24]-d))a[i]=(char)(121-d);else
            if((int)a[i]==((int)matryca[25]-d))a[i]=(char)(122-d);else;
        }
    }
    private int czyDuza(char a){
        int kod = (int) a;
        if(kod >= 97 && kod <= 122) return 0;
        else if (kod >= 65 && kod <= 90) return  32;
        return 0;
    }
    public void setKlucz(String klucz){
        kl = klucz.toCharArray();
    }

    public String getKlucz() {
        return new String(kl);
    }

}
