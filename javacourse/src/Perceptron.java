public class Perceptron {
    Double[] entrada;
    Double[] pesos;
    double funcaoativacao;

    public static int CalculaSoma(int[] entradas){
        int soma=0;
        for(int i=0;i<entradas.length;i++){  
         soma +=entradas[i];  
        }
        return soma;
    }

    public static Double CalculaSaida(Double[] entradas, double funcaoativacao, Double[] pesos){
        // y = E i=0 a i x1*x2 + c
        
        Double entraxpesos=0.0;
            for(int i=0;i<entradas.length;i++){
                for(int j=0;j<pesos.length;j++){
                   entraxpesos = (entradas[i]*pesos[j]) + funcaoativacao;
                }

            } 
         return entraxpesos;
    }

  public static void BackPropagation(Double[] testes, Double[] testesclassificados ){
    // calibra os pesos
    // calcula taxa de erros
    //MSE = (1/n) * ∑(i=1,n) (y_previsto[i] - y_correto[i])^2
    Double taxadeerro;
    Double diferenca_erroXacerto=0.0;
    Double soma =0.0;
   
    for(int i=0;i<testes.length;i++){
        for(int j=0;j<testesclassificados.length;j++){    
            diferenca_erroXacerto =  testesclassificados[j] - testes[i];
            soma += diferenca_erroXacerto * diferenca_erroXacerto;
        }
     
      
    }
    taxadeerro = soma/testesclassificados.length;
    System.out.println(taxadeerro);
  }

    public static void main(String[]args) throws Exception{
     Perceptron ia = new Perceptron();
    Double[] entradas = {1.0};
     Double[] pesos= {3.0};
     double funcaoativacao = 3.0;
     ia.entrada=entradas;
     ia.pesos=pesos;
     ia.funcaoativacao=funcaoativacao;

     Double[] valores ={1.0,2.0,3.0};
    Double[] classificado ={0.5,0.7,0.8};

    ia.BackPropagation(valores, classificado);
    }   
}
