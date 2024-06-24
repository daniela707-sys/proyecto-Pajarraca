package controlador;

import modelo.BDinventario;
import modelo.BDproductos;
import modelo.inventario;
import vista.vista;

public class controlador {
    public controlador() {
    }
    inventario i=new inventario();
    BDinventario bd=new BDinventario();
    BDproductos bDproducts=new BDproductos();
    vista v=new vista();

    public void ejecucion(){
        boolean control=true;
        while (control){
            int op=v.menu();
            switch (op){
                case 1:
                    int op1=v.menu1();
                    switch (op1){
                        case 1:
                            v.imprimir(bd.agregar(v.agregar()));
                            v.imprimir(bd.toString());
                            break;
                        case 2:
                            v.imprimir(bd.toString());
                            break;
                        case 3:
                            v.imprimir(bd.buscar(v.categoria()));
                            break;
                        case 4:
                            v.imprimir(bd.buscarnombre(v.nombre()));
                            break;
                        case 5:
                            v.imprimir(bd.actualizar(v.nombre(),v.color(),v.agregar()));
                            v.imprimir(bd.toString());
                            break;
                        case 6:
                            v.imprimir(bd.actualizarStock(v.nombre(),v.color(),v.stock()));
                            v.imprimir(bd.toString());
                            break;
                        case 7:
                            v.imprimir(bd.eliminar(v.nombre(),v.color()));
                            v.imprimir(bd.toString());
                            break;
                        case 8:
                            control=false;
                            break;
                    }
                case 2:
                    int op2=v.menu2();
                    switch (op2){
                        case 1:
                            v.imprimir(bDproducts.agregar(v.agregar2()));
                            v.imprimir(bDproducts.toString());
                            break;
                        case 2:
                            v.imprimir(bDproducts.toString());
                            break;
                        case 3:
                            v.imprimir(bDproducts.buscar(v.categoria()));
                            break;
                        case 4:
                            v.imprimir(bDproducts.actualizar(v.nombre(),v.color(),v.agregar2()));
                            v.imprimir(bDproducts.toString());
                            break;
                        case 5:
                            v.imprimir(bDproducts.eliminar(v.nombre(),v.color()));
                            v.imprimir(bDproducts.toString());
                            break;
                        case 6:
                            control=false;
                            break;
                    }
                case 3:
                    control=false;
                    break;
            }
        }
    }
}
