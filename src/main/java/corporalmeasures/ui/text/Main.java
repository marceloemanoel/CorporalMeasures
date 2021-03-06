package corporalmeasures.ui.text;

import corporalmeasures.CorporalMeasures;
import corporalmeasures.FemalePersonData;
import corporalmeasures.GastoCaloricoBasal;
import corporalmeasures.PersonData;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    private Scanner scanner;

    public Main(){
        scanner = new Scanner(System.in);
    }

    public PersonData collectPersonData() {
        System.out.println("Sexo: ");
        System.out.println("0 - Masculino");
        System.out.println("1 - Feminino");
        int sexo = Integer.parseInt(scanner.nextLine());

        PersonData personData;
        if(sexo == 0) personData = new PersonData();
        if(sexo == 1) personData = new FemalePersonData();
        throw new RuntimeException("Sexo inválido");

        System.out.println("Peso(em kg): ");
        peso = Double.parseDouble(scan.nextLine());

        System.out.println("Altura(em cm): ");
        altura = Double.parseDouble(scan.nextLine());

    }



	public static void main(String[] args) {

        Main main = new Main();
        PersonData personData = main.collectPersonData();

        System.out.println("Menu:");
        System.out.println("1 - Peso Ideal");
        System.out.println("2 - Gasto Calórico Basal");
        menuEscolhido = Integer.parseInt(scan.nextLine());

		if(menuEscolhido == 1){
			System.out.println("Cintura(em cm): ");
			cintura = Double.parseDouble(scan.nextLine());

			System.out.println("Pescoco(em cm): ");
			pescoco = Double.parseDouble(scan.nextLine());

			if(sexo.equals(1)){
				System.out.println("Quadril(em cm): ");
				quadril = Double.parseDouble(scan.nextLine());
				
				System.out.println("% gordura corporal	\tMulheres");
				System.out.println("Nivel de Competicao\t\t9%-12%");
				System.out.println("Bastante em forma	\t<= 15%");
				System.out.println("Em forma			\t16%-20%");
				System.out.println("Media 				\t21%-25%");
				System.out.println("Abaixo da media		\t26%-30%");
				System.out.println("Precisa de atencao	\t31%-40%+");
				System.out.println();
				System.out.println("% de gordura corporal desejada:");
				massaGordaDesejadaPercent = Double.parseDouble(scan.nextLine());
			}
            else{
				System.out.println("% gordura corporal\t\tHomens");
				System.out.println("Nivel de Competicao \t3%-6%");
				System.out.println("Bastante em forma	\t<= 9%");
				System.out.println("Em forma			\t10%-14%");
				System.out.println("Media 				\t15%-19%");
				System.out.println("Abaixo da media		\t20%-25%");
				System.out.println("Precisa de atencao 	\t26%-30%+");
				System.out.println();
				System.out.println("% de gordura corporal desejada:");
				massaGordaDesejadaPercent = Double.parseDouble(scan.nextLine());
			}
		}
		
		if(menuEscolhido == 2){
			HashMap<Integer, Double> NIVEL_ATIVIDADE_FISICA = new HashMap<Integer, Double>();
			NIVEL_ATIVIDADE_FISICA.put(1, 1.2);
			NIVEL_ATIVIDADE_FISICA.put(2, 1.375);
			NIVEL_ATIVIDADE_FISICA.put(3, 1.55);
			NIVEL_ATIVIDADE_FISICA.put(4, 1.725);
			NIVEL_ATIVIDADE_FISICA.put(5, 1.9);
				
			
			System.out.println("Nivel Atividade Fisica:");
			System.out.println("1 - Sedentario (praticamente nenhum exercicio)");
			System.out.println("2 - Levemente ativo (exercicio leve/esportes 1-3 dias/semana)");
			System.out.println("3 - Moderadamente ativo (exercicio moderado/esportes 3-5 dias/semana)");
			System.out.println("4 - Bastante ativo (exercicio forte/esportes 6-7 dias/semana)");
			System.out.println("5 - Extra ativo (trabalho fisico ou treinamento muito intenso)");
			System.out.println();
			Integer nivel_escolhido = Integer.parseInt(scan.nextLine());
			nivelAtividadeFisica = NIVEL_ATIVIDADE_FISICA.get(nivel_escolhido);

		}
		
		scan.close();

		CorporalMeasures mc = new CorporalMeasures();
        mc.setWeight(peso);
        mc.setWaist(cintura);
        mc.setNeck(pescoco);
        mc.setHeight(altura);
        mc.setQuadril(quadril);
        mc.setExpectedFatPercentage(massaGordaDesejadaPercent);
        mc.setSexo(sexo);
        mc.setNivelAtividadeFisica(nivelAtividadeFisica);
        mc.setAge(idade);
        mc.calculate();

		System.out.println();
		System.out.println("========RESULTADO============");

        if(menuEscolhido == 1){
			System.out.println("Massa Gorda(%): " + new DecimalFormat("#,###.00").format(mc.getFatPercentage()));
			System.out.println("Massa Magra(%): " + new DecimalFormat("#,###.00").format(mc.getMusclePercentage()));
			System.out.println();
			System.out.println("Massa Gorda(Kg): " + new DecimalFormat("#,###.00").format(mc.getMassaGordaKgs()));
			System.out.println("Massa Magra(Kg): " + new DecimalFormat("#,###.00").format(mc.getMassaMagraKgs()));
			System.out.println();
			System.out.println("Peso Ideal(Kg): "+new DecimalFormat("#,###.00").format(mc.getPesoIdeal()));
			System.out.println("Preciso Perder(Kg): "+new DecimalFormat("#,###.00").format(mc.getWeight()-mc.getPesoIdeal()));
			System.out.println();
		}
        else if(menuEscolhido == 2){
            GastoCaloricoBasal gcb = new GastoCaloricoBasal(personData, )
			System.out.println("Gasto Calorico Basal: "+new DecimalFormat("#,###.00").format(mc.getGastoCaloricoBasal()));
			System.out.println("Gasto Calorico Basal para dieta emagrecimento: "+new DecimalFormat("#,###.00").format(mc.getGastoCaloricoBasalNivelDietaEmagrecimento()));
			System.out.println("Gasto Calorico Basal para hipertrofia: "+new DecimalFormat("#,###.00").format(mc.getGastoCaloricoBasalNivelDietaHipertrofia()));
			System.out.println();
		}
	}	
}
