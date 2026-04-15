/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Proceso { // Patron 1: Nombre poco claro | Patron 6: No define bien su responsabilidad

public static double hacerTodo(){ // Patron 1: Nombre no describe lo que hace | Patron 2: Demasiadas responsabilidades
double sub=0;double iva=0;double tot=0;double aux=0;int cont=0;int i=0; 
// Patron 1: Nombres poco claros | Patron 7: Todo en una sola linea

while(i<Datos.nom.length){ // Patron 2: Acoplamiento fuerte a Datos
if(Datos.cant[i]>0){
sub=sub+Datos.p[i]*Datos.cant[i]; // Patron 4: Expresion poco clara
cont=cont+1;}
i++;} // fin while

if(cont>3){ // Patron 8: Valor hardcodeado
if(sub>0){
aux=sub-(sub*0.05); // Patron 8: Porcentaje hardcodeado
if(aux>50000){ // Patron 8
iva=aux*0.19; // Patron 8
tot=aux+iva;
tot=tot+(tot*0.10);} // Patron 8
else{
iva=aux*0.19;
tot=aux+iva;}} // fin if sub>0

// version anterior - no borrar // Patron 3: Comentario innecesario (no aporta valor)
// sub = sub * 1.19;
// if(sub > 40000) sub = sub + (sub*0.10);
// return sub;

}else{
if(sub>50000){ // Patron 8
iva=sub*0.19;
tot=sub+iva;
tot=tot+(tot*0.10);} // Patron 8
else{
iva=sub*0.19;
tot=sub+iva;}} // fin if-else cont

Datos.est=1;Datos.tot=tot; // Patron 2: Cambia estado global (mezcla responsabilidades)
return tot;} // Patron 2

public static double procesar(double a,double b,double c,double d,double e,int f,boolean g){ 
// Patron 1: Parametros sin significado | Patron 2: Funcion poco clara
double res=0;double iva=0;double prop=0;double tmp=0; 
// Patron 1: Nombres poco claros | Patron 7

res=a*b; // Patron 1: No se entiende que representa
if(c>0){
res=res-(res*c);} // Patron 8: Descuento sin constante definida

iva=res*d;tmp=iva; // Patron 4: Variable innecesaria (tmp)
res=res+tmp;

if(g){
prop=res*e;
res=res+prop;} // Patron 8: Propina hardcodeada indirectamente

if(f>3){ // Patron 8
res=res-(res*0.01);} // Patron 8

return res;} // Patron 2

} // Patron 6: Clase con logica mezclada y poco organizada