/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Imprimir { // Patron 1: Nombre poco especifico | Patron 6: No define claramente su responsabilidad

public static void mostrarCarta(){ // Patron 2: Mezcla logica de presentacion con acceso a datos
System.out.println("========================================"); // Patron 8: Valor hardcodeado
System.out.println("    RESTAURANTE EL BUEN SABOR"); // Patron 8: Texto hardcodeado
System.out.println("    --- NUESTRA CARTA ---"); // Patron 8: Texto hardcodeado
System.out.println("========================================"); // Patron 8: Valor hardcodeado
int i=0; // Patron 1: Nombre poco descriptivo
while(i<Datos.nom.length){ // Patron 2: Acoplamiento directo a Datos
System.out.printf("%d. %-22s $%,.0f%n",(i+1),Datos.nom[i],Datos.p[i]); // Patron 8: Formato hardcodeado
i++;} // fin while
System.out.println("========================================");} // Patron 7: Llaves mal organizadas

public static void mostrarPedido(){ // Patron 2: Mezcla calculo e impresion
double sub=0;int i=0; // Patron 1: Nombres poco claros | Patron 7: mala separacion
System.out.println("--- PEDIDO ACTUAL ---"); // Patron 8: Texto hardcodeado
while(i<Datos.nom.length){ // Patron 2: Dependencia de Datos
if(Datos.cant[i]>0){
System.out.printf("%-20s x%-6d $%,.0f%n",Datos.nom[i],Datos.cant[i],(Datos.p[i]*Datos.cant[i])); // Patron 8
sub=sub+Datos.p[i]*Datos.cant[i];} // Patron 4: Expresion poco clara
i++;} // fin while
System.out.println("--------------------"); // Patron 8
System.out.printf("%-27s $%,.0f%n","Subtotal:",sub);} // Patron 8

public static void imprimirFacturaCompleta(){ // Patron 2: Demasiadas responsabilidades
double sub=0;double iva=0;double tot=0;double prop=0;int cont=0;double aux=0; 
// Patron 1: Nombres poco claros | Patron 7: todo en una linea

int i=0;while(i<Datos.nom.length){ // Patron 4: Mala legibilidad
if(Datos.cant[i]>0){
sub=sub+Datos.p[i]*Datos.cant[i];cont=cont+1;} // Patron 4: multiples operaciones juntas
i++;} // fin while

if(cont>3){aux=sub-(sub*0.05);}else{aux=sub;} // Patron 8: valores hardcodeados

if(aux>50000){ // Patron 8
iva=aux*0.19; // Patron 8
tot=aux+iva;
prop=tot*0.10; // Patron 8
tot=tot+prop;}
else{
iva=aux*0.19;
tot=aux+iva;
prop=0;} // Patron 8

String sep="========================================"; // Patron 8
System.out.println(sep);
System.out.println("    RESTAURANTE EL BUEN SABOR"); // Patron 8
System.out.println("    Calle 15 #8-32, Valledupar"); // Patron 8
System.out.println("    NIT: 900.123.456-7"); // Patron 8
System.out.println(sep);
System.out.printf("FACTURA No. %03d%n",Datos.nf); // Patron 2: uso directo de Datos
System.out.println("----------------------------------------"); // Patron 8

int j=0;while(j<Datos.nom.length){ // Patron 4: mala legibilidad
if(Datos.cant[j]>0){
System.out.printf("%-20s x%-6d $%,.0f%n",Datos.nom[j],Datos.cant[j],(Datos.p[j]*Datos.cant[j]));}
j++;} // fin while

System.out.println("----------------------------------------"); // Patron 8
System.out.printf("%-27s $%,.0f%n","Subtotal:",aux);
System.out.printf("%-27s $%,.0f%n","IVA (19%):",iva); // Patron 8
if(prop>0){
System.out.printf("%-27s $%,.0f%n","Propina (10%):",prop);} // Patron 8
System.out.println("----------------------------------------");
System.out.printf("%-27s $%,.0f%n","TOTAL:",tot);
System.out.println(sep);
System.out.println("Gracias por su visita!"); // Patron 8
System.out.println("El Buen Sabor - Valledupar"); // Patron 8
System.out.println(sep);

Datos.nf=Datos.nf+1; // Patron 2: logica de negocio en impresion
Datos.est=0; // Patron 2
Datos.tot=tot;} // Patron 2

public static void imprimirFacturaResumen(){ // Patron 2: Duplica logica
double sub=0;double iva=0;double tot=0;double prop=0;int cont=0;double aux=0; 
// Patron 1 y Patron 7

int i=0;while(i<Datos.nom.length){
if(Datos.cant[i]>0){
sub=sub+Datos.p[i]*Datos.cant[i];cont=cont+1;}
i++;} // fin while
// Patron 10: codigo duplicado

if(cont>3){aux=sub-(sub*0.05);}else{aux=sub;} // Patron 8

if(aux>50000){
iva=aux*0.19;
tot=aux+iva;
prop=tot*0.10;
tot=tot+prop;}
else{
iva=aux*0.19;
tot=aux+iva;
prop=0;} // Patron 8

String sep="========================================"; // Patron 8
System.out.println(sep);
System.out.println("    RESTAURANTE EL BUEN SABOR"); // Patron 8
System.out.println("    Calle 15 #8-32, Valledupar"); // Patron 8
System.out.println("    NIT: 900.123.456-7"); // Patron 8
System.out.println(sep);
System.out.printf("FACTURA No. %03d (RESUMEN)%n",Datos.nf);
System.out.println("----------------------------------------");
System.out.printf("%-27s $%,.0f%n","Subtotal:",aux);
System.out.printf("%-27s $%,.0f%n","IVA (19%):",iva);
if(prop>0){
System.out.printf("%-27s $%,.0f%n","Propina (10%):",prop);}
System.out.println("----------------------------------------");
System.out.printf("%-27s $%,.0f%n","TOTAL:",tot);
System.out.println(sep);}    

} // Patron 6: Clase con demasiadas responsabilidades