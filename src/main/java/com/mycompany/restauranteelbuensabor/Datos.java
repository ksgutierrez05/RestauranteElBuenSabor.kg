/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Datos { // Patrón 1: Nombre muy genérico (no describe propósito) ;Patrón 6: Mala estructura (clase sin responsabilidad clara)

public static String[] nom={"Bandeja Paisa","Sancocho de Gallina","Arepa con Huevo","Jugo Natural","Gaseosa","Cerveza Poker","Agua Panela","Arroz con Pollo"}; 
// Patrón 1: "nom" no es descriptivo ;Patrón 4: Línea muy larga ;Patrón 7: Mal formato; Patrón 8: Valores hardcodeados

public static double[] p={32000,28000,8000,7000,4500,6000,3500,25000}; 
// Patrón 1: "p" no tiene significado ; Patrón 4: Poco legible ;Patrón 8: Valores hardcodeados

public static int[] cant={0,0,0,0,0,0,0,0}; 
// Patrón 1: "cant" poco claro ;Patrón 8: Inicialización hardcodeada ;Patrón 2: Mezcla responsabilidades

public static int ms=0; 
//Patrón 1: "ms" no se entiende ;Patrón 4: Reduce legibilidad

public static int est=0; 
// Patrón 1: "est" ambiguo ;Patrón 4: Difícil de entender

public static double tot=0; 
// Patrón 1: "tot" poco claro (debería ser "total") ;Patrón 8: Valor fijo

public static int nf=1; 
// Patrón 1: "nf" no es claro (¿número de factura?) ;Patrón 8: Valor hardcodeado

public static String x="El Buen Sabor"; 
// Patrón 1: "x" no tiene significado ; Patrón 8: Valor hardcodeado

public static String tmp="";    
// Patrón 1: "tmp" no describe su uso, mala práctica general (variable innecesaria o mal definida)

} // Patrón 6: Clase con demasiadas responsabilidades (no separa lógica)
