package br.ifba.inf011.solid.model;

public enum Cargo {
	ASSISTENTE{
		@Override
		public Cargo proximoCargo() {
			return Cargo.AUXILIAR;
		}
	},	
	
	AUXILIAR{
		@Override
		public Cargo proximoCargo() {
			return Cargo.SENIOR;
		}
	},	
	
	SENIOR{
		@Override
		public Cargo proximoCargo() {
			return Cargo.TITULAR;
		}
	},
	
	TITULAR{
		@Override
		public Cargo proximoCargo() {
			return Cargo.TITULAR;
		}
	};	
	
	public abstract Cargo proximoCargo();
	
}
