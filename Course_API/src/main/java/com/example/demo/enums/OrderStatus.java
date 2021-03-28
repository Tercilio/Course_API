package com.example.demo.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), 
	PAID(2), 
	SHIPPED(3), 
	DELIVERED(4), 
	CANCELED(5);

	private int code; //CÓDIGO PRA O TIPO ENUMERADO

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() { //PARA O MÉTODO FICAR ACESSÍVEL EM OUTRAS CLASSES
		return code;
	}

	public static OrderStatus valueOf(int code) {    // CONVERTER VALOR NUMÉRICO PARA O TIPO ENUMERADO
		for (OrderStatus value : OrderStatus.values()) { //PERCORRER TODOS OS ORDERS E para cada um TESTE SE É O CÓDIGO RECEBIDO (code)
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code"); //CÓDIGO NÃO EXISTE!!!
	}
}
