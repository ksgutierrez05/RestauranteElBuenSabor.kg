/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Utilidades { // Patron 6: Clase con multiples responsabilidades (calculo, validacion, estado)

public static double calcular(double pr,double cn,double dc,double iv,double pp,int ni,boolean ap){
// Patron 1: Parametros sin significado | Patron 2: Metodo mezcla calculo e impresion

double res=0;double tmp=0;double aux2=0; 
// Patron 1: Nombres poco claros | Patron 7: Todo en una sola linea

res=pr*cn; // Patron 1: No es claro que representa
if(dc>0){res=res-(res*dc);} // Patron 8: Descuento hardcodeado sin constante

tmp=res*iv;res=res+tmp; // Patron 4: Dos operaciones en una linea
if(ap){res=res+(res*pp);} // Patron 8: Propina sin constante clara

System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado"); 
// Patron 2: Mezcla logica con presentacion | Patron 8: Texto hardcodeado

aux2=res; // Patron 4: Variable innecesaria
return aux2;} // Patron 4: Retorno innecesariamente indirecto

public static boolean validar(){ // Patron 2: Metodo hace validacion y modifica estado
int cont=0;int i=0; // Patron 1: Nombres poco claros

while(i<Datos.cant.length){ // Patron 2: Dependencia directa de Datos
if(Datos.cant[i]>0){cont=cont+1;}
i++;} // fin while

// reinicia si no hay nada - efecto secundario no documentado
if(cont==0){Datos.tot=0;Datos.tmp="";} 
// Patron 2: Efecto secundario oculto | Patron 3: Comentario no explica bien el impacto

return cont>0;}

public static void reiniciar(){ // Patron 2: Maneja estado global directamente

// metodo antiguo de calculo - pendiente revisar
// Patron 3: Comentarios innecesarios (codigo muerto, deberia eliminarse)

// public static double calcOld(double precio, int cant){
// double resultado = 0;
// resultado = precio * cant;
// resultado = resultado + (resultado * 0.19);
// if(resultado > 50000){
// resultado = resultado + (resultado * 0.10);}
// System.out.println("RESTAURANTE EL BUEN SABOR");
// System.out.println("Total: " + resultado);
// return resultado;}

// double sub=0;int i=0;
// while(i<Datos.nom.length){
// sub=sub+Datos.p[i]*Datos.cant[i];i++;}
// if(sub>50000){ sub=sub+(sub*0.19); sub=sub+(sub*0.10); }
// else{ sub=sub+(sub*0.19); }
// Datos.tot=sub;

int i=0;while(i<Datos.cant.length){Datos.cant[i]=0;i++;} 
// Patron 4: Mala legibilidad (todo en una linea)

Datos.tot=0;Datos.est=0;Datos.ms=0;Datos.tmp=""; 
// Patron 7: Multiples asignaciones en una linea | Patron 2: Manipulacion global

}    
}