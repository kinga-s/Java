//@Kinga Syta
public class Plansza {
    public static int wiersz;
    public static int kolumna;
    public static int[][]plan={{0,2,0,2,0,2,0,2},
                        {2,0,2,0,2,0,2,0},
                        {0,2,0,2,0,2,0,2},
                        {1,0,1,0,1,0,1,0},
                        {0,1,0,1,0,1,0,1},
                        {3,0,3,0,3,0,3,0},
                        {0,3,0,3,0,3,0,3},
                        {3,0,3,0,3,0,3,0}};

    public static void nrPola(int x, int y){
        if(x>10&&x<410&&y>10&&y<410) {
            wiersz= (y-10)/50;
            kolumna=(x-10)/50;
        }
    }
    private static int ww=-1,kk=-1, dww=-1, dkk=-1;

    private static boolean bicieWielok=false;

    private static void ustawienie1(int w, int k){
        plan[ww][kk]=1;
        if(w==7){
            plan[w][k]=4;
        }
        else
            plan[w][k]=2;
        ww=-1;
        kk=-1;
        if(!bicieWielok){
            GrafiPlansza.gracz=2;
        }
    }

    private static void ustawienie2(int w, int k){
        plan[ww][kk]=1;
        if(w==0){
            plan[w][k]=6;
        }
        else
            plan[w][k]=3;
        ww=-1;
        kk=-1;
        if(!bicieWielok){
            GrafiPlansza.gracz=1;
        }
    }

    private static void ustawienieD1(int w, int k){
        plan[w][k]=4;
        plan[dww][dkk]=1;
        dww=-1; dkk=-1;
        GrafiPlansza.gracz=2;
    }

    private static void ustawienieD2(int w, int k){
        plan[w][k]=6;
        plan[dww][dkk]=1;
        dww=-1; dkk=-1;
        GrafiPlansza.gracz=1;
    }

    private  static void ruchDamki1(int w, int k){
        if((dww-w)==(dkk-k)){
            for (int i = 1; i < (dww - w); i++) {
                if (plan[dww - i][dkk - i] == 3 || plan[dww - i][dkk - i] == 6) {
                    if (plan[dww - i - 1][dkk - i - 1] == 1 && (i == 1 || plan[dww - i + 1][dkk - i + 1] == 1)) {
                        plan[dww - i][dkk - i] = 1;
                    }
                }
            }

            for (int i = 1; i < (w - dww); i++) {
                if (plan[dww + i][dkk + i] == 3 || plan[dww + i][dkk + i] == 6) {
                    if (plan[dww + i + 1][dkk + i + 1] == 1 && (i == 1 || plan[dww + i - 1][dkk + i - 1] == 1)) {
                        plan[dww + i][dkk + i] = 1;
                    }
                }
            }
            ustawienieD1(w,k);
        }

        else if((dww-w)==(k-dkk)){
            for (int i = 1; i < (dww - w); i++) {
                if (plan[dww - i][dkk + i] == 3 || plan[dww - i][dkk + i] == 6) {
                    if (plan[dww - i - 1][dkk + i + 1] == 1 && (i == 1 || plan[dww - i + 1][dkk + i - 1] == 1)) {
                        plan[dww - i][dkk + i] = 1;
                    }
                }
            }

            for (int i = 1; i < (w - dww); i++) {
                if (plan[dww + i][dkk - i] == 3 || plan[dww + i][dkk - i] == 6) {
                    if (plan[dww + i + 1][dkk - i - 1] == 1 && (i == 1 || plan[dww + i - 1][dkk - i + 1] == 1)) {
                        plan[dww + i][dkk - i] = 1;
                    }
                }
            }
            ustawienieD1(w,k);
        }
    }

    private static void ruchDamki2(int w, int k){
        if((dww-w)==(dkk-k)){
            for (int i = 1; i < (dww - w); i++) {
                if (plan[dww - i][dkk - i] == 2 || plan[dww - i][dkk - i] == 4) {
                    if (plan[dww - i - 1][dkk - i - 1] == 1 && (i == 1 || plan[dww - i + 1][dkk - i + 1] == 1)) {
                        plan[dww - i][dkk - i] = 1;
                    }
                }
            }

            for (int i = 1; i < (w - dww); i++) {
                if (plan[dww + i][dkk + i] == 2 || plan[dww + i][dkk + i] == 4) {
                    if (plan[dww + i + 1][dkk + i + 1] == 1 && (i == 1 || plan[dww + i - 1][dkk + i - 1] == 1)) {
                        plan[dww + i][dkk + i] = 1;
                    }
                }
            }
            ustawienieD2(w,k);
        }

        else if((dww-w)==(k-dkk)){
            for (int i = 1; i < (dww - w); i++) {
                if (plan[dww - i][dkk + i] == 2 || plan[dww - i][dkk + i] == 4) {
                    if (plan[dww - i - 1][dkk + i + 1] == 1 && (i == 1 || plan[dww - i + 1][dkk + i - 1] == 1)) {
                        plan[dww - i][dkk + i] = 1;
                    }
                }
            }

            for (int i = 1; i < (w - dww); i++) {
                if (plan[dww + i][dkk - i] == 2 || plan[dww + i][dkk - i] == 4) {
                    if (plan[dww + i + 1][dkk - i - 1] == 1 && (i == 1 || plan[dww + i - 1][dkk - i + 1] == 1)) {
                        plan[dww + i][dkk - i] = 1;
                    }
                }
            }
            ustawienieD2(w,k);
        }
    }

    public static void gracz1(int w, int k){
        if(plan[w][k]==2) {
            ww=w;
            kk=k;
            dww=-1; dkk=-1;
        }
         else if(plan[w][k]==1 && ww!=-1){
            if((ww+1)==w && ((kk+1)==k || (kk-1)==k)) {
                ustawienie1(w,k);
                }
            if((ww+2)==w && (kk+2)==k && (plan[ww+1][kk+1]==3 || plan[ww+1][kk+1]==6)){
                plan[ww+1][kk+1]=1;
                ustawienie1(w,k);
            }
            if((ww+2)==w && (kk-2)==k && (plan[ww+1][kk-1]==3 || plan[ww+1][kk-1]==6)){
                plan[ww+1][kk-1]=1;
                ustawienie1(w,k);
            }
            if((ww-2)==w && (kk+2)==k && (plan[ww-1][kk+1]==3 || plan[ww-1][kk+1]==6)){
                plan[ww-1][kk+1]=1;
                ustawienie1(w,k);
            }
            if((ww-2)==w && (kk-2)==k && (plan[ww-1][kk-1]==3 || plan[ww-1][kk-1]==6)){
                plan[ww-1][kk-1]=1;
                ustawienie1(w,k);
            }
        }
        else if(plan[w][k]==4) {
            dww=w;
            dkk=k;
            ww=-1; kk=-1;
        }
        else if(plan[w][k]==1 && dww!=-1){
            ruchDamki1(w,k);
        }
    }


    //------------------------------------------------------------------




    public static void gracz2(int w, int k){
        if(plan[w][k]==3 && !bicieWielok){
            ww=w;
            kk=k;
            dww=-1; dkk=-1;
        }
        if(plan[w][k]==1 && ww!=-1) {
            if ((ww - 1) == w && ((kk + 1) == k || (kk - 1) == k)) {
                ustawienie2(w, k);
            }


            if ((ww + 2) == w && (kk + 2) == k && (plan[ww + 1][kk + 1] == 2 || plan[ww + 1][kk + 1] == 4)) {
                plan[ww + 1][kk + 1] = 1;
                ustawienie2(w, k);
            }
            if ((ww + 2) == w && (kk - 2) == k && (plan[ww + 1][kk - 1] == 2 || plan[ww + 1][kk - 1] == 4)) {
                plan[ww + 1][kk - 1] = 1;
                ustawienie2(w, k);
            }
            if ((ww - 2) == w && (kk + 2) == k && (plan[ww - 1][kk + 1] == 2 || plan[ww - 1][kk + 1] == 4)) {
                plan[ww - 1][kk + 1] = 1;
                ustawienie2(w, k);
            }
            if ((ww - 2) == w && (kk - 2) == k && (plan[ww - 1][kk - 1] == 2 || plan[ww - 1][kk - 1] == 4)) {
                plan[ww - 1][kk - 1] = 1;
                ustawienie2(w, k);
            }
        }

        if(plan[w][k]==6){
            dww=w;
            dkk=k;
            ww=-1; kk=-1;
        }
        else if(plan[w][k]==1 && dww!=-1){
            ruchDamki2(w,k);
        }
    }
}