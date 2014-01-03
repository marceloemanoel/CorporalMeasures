package corporalmeasures;

public class MedidasCorporais{

    private Double peso;
    private Double cintura;
	private Double pescoco;
	private Double altura;
	private Double quadril;
	private Double massaMagraPerc;
	private Double massaGordaPerc;
	private Double massaGordaPercDesejada;
	private Double nivelAtividadeFisica;
	private Integer sexo = 1;
	private Integer idade;
	public static final Integer SEXO_MASCULINO = 0;
	public static final Integer SEXO_FEMININO = 1;
	

	public void calculate(){
		this.setMassaGordaPerc(sexo);
		this.setMassaMagraPerc();
	}

	public Double getPesoIdeal() {
		return  (this.peso - (this.massaGordaPerc / 100 * this.peso)) / (1 - (this.massaGordaPercDesejada / 100));
	}

	private void setMassaGordaPerc(int sexo){
		if(sexo == SEXO_MASCULINO){
			this.massaGordaPerc = (495/((1.0324-((Math.log(cintura-pescoco)/Math.log(10))*0.19077)) + (Math.log(altura)/Math.log(10))*0.15456))-450;
		}else{
			this.massaGordaPerc = ( 495 / ((1.29579 - (0.35004*(Math.log((quadril+cintura)-pescoco)/Math.log(10)))) + (Math.log(altura)/Math.log(10)) * 0.22100) )-450;
		}
	}
	private void setMassaMagraPerc(){
		this.massaMagraPerc = (100.0 - this.massaGordaPerc);
	}
	public Double getMassaMagraKgs(){
		return (this.massaMagraPerc/100)*this.peso; 
	}
	
	public Double getMassaGordaKgs(){
		return (this.massaGordaPerc/100)*this.peso; 
	}
	
	public Double getGastoCaloricoBasal(){
		return ((10*this.peso)+(6.25*this.altura)-(5*this.idade)+5)*this.nivelAtividadeFisica;
	}

	public Double getGastoCaloricoBasalNivelDietaEmagrecimento(){
		return (((10*this.peso)+(6.25*this.altura)-(5*this.idade)+5)*this.nivelAtividadeFisica)*0.8;
	}

	public Double getGastoCaloricoBasalNivelDietaHipertrofia(){
		return (((10*this.peso)+(6.25*this.altura)-(5*this.idade)+5)*this.nivelAtividadeFisica)*1.2;
	}

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setCintura(Double cintura) {
        this.cintura = cintura;
    }

    public void setPescoco(Double pescoco) {
        this.pescoco = pescoco;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public void setQuadril(Double quadril) {
        this.quadril = quadril;
    }

    public Double getMassaMagraPerc() {
        return massaMagraPerc;
    }

    public Double getMassaGordaPerc() {
        return massaGordaPerc;
    }

    public void setMassaGordaPercDesejada(Double massaGordaPercDesejada) {
        this.massaGordaPercDesejada = massaGordaPercDesejada;
    }

    public void setNivelAtividadeFisica(Double nivelAtividadeFisica) {
        this.nivelAtividadeFisica = nivelAtividadeFisica;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}