import scala.io.Source


object archivos{

    def lecturaArchivos() : String = {
        var lineas : Int = 0
        var arch :  String = Source.fromFile("scala_archivos/conexionBD.java").mkString
        var esp : Int = 0
        var corDer : Int = 0
        var corIzq : Int = 0
        var llavDer : Int = 0
        var llavIzq : Int = 0
        var parDer : Int = 0
        var parIzq : Int = 0

        for(a <- 0 to arch.length()-1){
            var sim : Char = arch.charAt(a)
            if(sim == '\n'){
                lineas += 1
            }
            else if(sim == ' '){
                esp += 1
            }
            else if(sim == '{'){
                corDer += 1
            }
            else if(sim == '}'){
                corIzq += 1
            }
            else if(sim == '('){
                parDer += 1
            }
            else if(sim == ')'){
                parIzq += 1
            }
            else if(sim == '['){
                llavDer += 1
            }
            else if(sim == ']'){
                llavIzq += 1
            }
        }

        var l = ""
        var c = ""
        var p = ""

        if(corDer == corIzq){
            c = "los corchetes estan balanceados"
        }
        else{
            c = "los corchetes no estan balanceados"
        }
        if(llavIzq == llavDer){
            l = "las llaves estan balanceados"
        }
        else{
            l ="las llaves no estan balanceados"
        }
        if(parIzq == parDer){
            p = "los parentesis estan balanceados"
        }
        else{
            p = "los parentesis no estan balanceados"
        }

        /*println(lineas)
        println(esp)
        println(corDer)
        println(corIzq)
        println(llavIzq)
        println(llavDer)
        println(parIzq)
        println(parDer)*/
        var finalCad : String = "cantidad de lineas: "+lineas+"\ncantidad de espacios: "+esp+"\n"+p+"\n"+c+"\n"+l
        finalCad
    }

    def main(args: Array[String]) : Unit = {
        print(lecturaArchivos())
    }
}