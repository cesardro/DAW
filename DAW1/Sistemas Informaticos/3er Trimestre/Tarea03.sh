#!/bin/bash

echo Bienvenido al juego de BlackJack!

contJug=0
contCru=0

CJ1=$(shuf -i 1-13 -n 1)
CJ2=$(shuf -i 1-13 -n 1)
CC1=$(shuf -i 1-13 -n 1)
CC2=$(shuf -i 1-13 -n 1)

echo ---------------------- JUGADOR ----------------------
echo 

flag=0

if [ $CJ1 -ne 1 -a $CJ2 -ne 1 ];then
	if [ $CJ1 -eq 11 -o $CJ1 -eq 12 -o $CJ1 -eq 13 ];then
		contJug=$((contJug+10))
		echo Valor de primera carta: 10
	else
		contJug=$((contJug+CJ1))
		echo Valor de primera carta: $CJ1
	fi

	if [ $CJ2 -eq 11 -o $CJ2 -eq 12 -o $CJ2 -eq 13 ];then
                contJug=$((contJug+10))
		echo Valor de segunda carta: 10
        else
                contJug=$((contJug+CJ2))
		echo Valor de segunda carta: $CJ2
        fi
else
	if [ $CJ1 -eq 1 -a $CJ2 -eq 1 ];then
	        echo Te ha tocado un doble AS, escoge 1 u 11 de la primera carta:
       		read asNum
       		while [ $flag -ne 1 ];do
               		if [ $asNum -eq 1 ];then
                       		flag=1
                       		contJug=$((contJug+1))
				echo Valor primera carta: $asNum
               		elif [ $asNum -eq 11 ];then
                       		flag=1
                       		contJug=$((contJug+11))
				echo Valor primera carta: $asNum
               		elif [ $flag -eq 0 ];then
                       		echo Número invalido, intentalo de nuevo:
                       		read asNum
               		fi
       		done
		flag=0
       		echo Escoge 1 u 11 de la segunda carta:
       		read asNum
       		while [ $flag -ne 1 ];do
               		if [ $asNum -eq 1 ];then
                       		flag=1
                       		contJug=$((contJug+1))
				echo Valor segunda carta: $asNum
               		elif [ $asNum -eq 11 ];then
                       		flag=1
                       		contJug=$((contJug+11))
				echo Valor segunda carta: $asNum
               		elif [ $flag -eq 0 ];then
                       		echo Número invalido, intentalo de nuevo:
                       		read asNum
               		fi
       		done
	else
		flag=0
		if [ $CJ1 -eq 1 ];then
			echo Te ha tocado un AS en la primera carta y en la segunda no, escoge 1 u 11:
			echo Este es el valor de la segunda carta: $CJ2
			read asNum
			while [ $flag -ne 1 ];do
	                        if [ $asNum -eq 1 ];then
        	                        flag=1
                	                contJug=$((contJug+1))
					contJug=$((contJug+$CJ2))
                        	        echo Valor primera carta: $asNum
					echo Valor segunda carta: $CJ2
	                        elif [ $asNum -eq 11 ];then
        	                        flag=1
                	                contJug=$((contJug+11))
					contJug=$((contJug+$CJ2))
                        	        echo Valor primera carta: $asNum
					echo Valor segunda carta: $CJ2
	                        elif [ $flag -eq 0 ];then
        	                        echo Número invalido, intentalo de nuevo:
                	                read asNum
                        	fi
                	done
		elif [ $CJ2 -eq 1 ];then
			echo Te ha tocado un AS en la segunda carta y en la primera no, escoge 1 u 11:
			echo Este es el valor de la primera carta: $CJ1
			read asNum
			while [ $flag -ne 1 ];do
                                if [ $asNum -eq 1 ];then
                                        flag=1
                                        contJug=$((contJug+1))
                                        contJug=$((contJug+$CJ1))
                                        echo Valor primera carta: $CJ1
                                        echo Valor segunda carta: $asNum
                                elif [ $asNum -eq 11 ];then
                                        flag=1
                                        contJug=$((contJug+11))
                                        contJug=$((contJug+$CJ1))
                                        echo Valor primera carta: $CJ1
                                        echo Valor segunda carta: $asNum
                                elif [ $flag -eq 0 ];then
                                        echo Número invalido, intentalo de nuevo:
                                        read asNum
                                fi
                        done
		fi
	fi
fi

if [ $CC1 -eq 11 -o $CC1 -eq 12 -o $CC1 -eq 13 ];then
	echo Esta es la carta del CRUPIER: 10
else
	echo Esta es la carta del CRUPIER: $CC1
fi

echo Jugador: Suma total del valor de tus cartas: $contJug

if [ $contJug -lt 22 ];then
	echo Es el momento de pedir cartas o plantarse, escoge sabiamente:
	echo Di: "carta" o "plantarse"
	read pideC

	while [ "$pideC" = carta ];do
		pideMas=$(shuf -i 1-13 -n 1)
		if [ $pideMas -eq 11 -o $pideMas -eq 12 -o $pideMas -eq 13 ];then
			contJug=$((contJug+10))
			pideMas=10
		elif [ $pideMas -eq 1 ];then
			echo Te ha salido un AS, escoge entre 1 u 11:
			read asNum
			flag=0
			while [ $flag -ne 1 ];do
                                if [ $asNum -eq 1 ];then
                                        flag=1
                                        contJug=$((contJug+1))
                                        echo Has escogido 1, nuevo total: $contJug
                                elif [ $asNum -eq 11 ];then
                                        flag=1
                                        contJug=$((contJug+11))
                                        echo Has escogido 11, nuevo total: $contJug
                                elif [ $flag -eq 0 ];then
                                        echo Número invalido, intentalo de nuevo:
                                        read asNum
                                fi
                        done
		else
			contJug=$((contJug+pideMas))
			echo Valor de la carta nueva: $pideMas
			echo Nuevo total: $contJug
		fi
		if [ $contJug -gt 21 ];then
			echo Has perdido y el crupier se lleva tu dinero.
			echo El valor de la carta era: $pideMas
			echo Tu total fue: $contJug
			
			exit
		else
			echo ¿Carta o plantarse?
			read pideC
		fi
	done
else
	echo Has perdido y el crupier se lleva tu dinero.
	exit
fi

echo ---------------------- CRUPIER ----------------------

if [ $CC1 -ne 1 -a $CC2 -ne 1 ];then
	if [ $CC1 -eq 11 -o $CC1 -eq 12 -o $CC1 -eq 13 ];then
		contCru=$((contCru+10))
		echo CRUPIER: Valor de primera carta: 10
	else
		contCru=$((contCru+CC1))
		echo CRUPIER: Valor de primera carta: $CC1
	fi

	if [ $CC2 -eq 11 -o $CC2 -eq 12 -o $CC2 -eq 13 ];then
                contCru=$((contCru+10))
		echo CRUPIER: Valor de segunda carta: 10
        else
                contCru=$((contCru+CC2))
		echo CRUPIER: Valor de segunda carta: $CC2
        fi
        echo CRUPIER: Valor total: $contCru
        while [ $contCru -lt 17 ];do
		pideMas=$(shuf -i 1-13 -n 1)
		echo CRUPIER: Pide otra carta.
		if [ $pideMas -eq 11 -o $pideMas -eq 12 -o $pideMas -eq 13 ];then
			echo CRUPIER: Valor de la nueva carta: 10
			contCru=$((contCru+10))
		else
			echo CRUPIER: Valor de la nueva carta: $pideMas
			contCru=$((contCru+pideMas))
		fi
		echo CRUPIER: Nuevo total: $contCru
	done
else
	if [ $CC1 -eq 1 -a $CC2 -eq 1 ];then
		echo Al CRUPIER le ha tocado doble AS, tiene un total de: 12.
		contCru=12
	else
		if [ $CC1 -eq 1 ];then
			contCru=$((CC2+11))
			echo CRUPIER: Valor de primera carta: 11
			echo CRUPIER: Valor de segunda carta: $CC2
			echo CRUPIER: Valor total de las cartas: $contCru
			while [ $contCru -lt 17 ];do
				pideMas=$(shuf -i 1-13 -n 1)
				echo CRUPIER: Pide otra carta.
				if [ $pideMas -eq 11 -o $pideMas -eq 12 -o $pideMas -eq 13 ];then
					echo CRUPIER: Valor de la nueva carta: 10
					contCru=$((contCru+10))
				else
					echo CRUPIER: Valor de la nueva carta: $pideMas
					contCru=$((contCru+pideMas))
				fi
				echo CRUPIER: Nuevo total: $contCru
			done
		elif [ $CC2 -eq 1 ];then
			contCru=$((CC1+11))
			echo CRUPIER: Valor de primera carta: $CC1
			echo CRUPIER: Valor de segunda carta: 11
			echo CRUPIER: Valor total de las cartas: $contCru
			while [ $contCru -lt 17 ];do
				pideMas=$(shuf -i 1-13 -n 1)
				echo CRUPIER: Pide otra carta.
				if [ $pideMas -eq 11 -o $pideMas -eq 12 -o $pideMas -eq 13 ];then
					echo CRUPIER: Valor de la nueva carta: 10
					contCru=$((contCru+10))
				else
					echo CRUPIER: Valor de la nueva carta: $pideMas
					contCru=$((contCru+pideMas))
				fi
				echo CRUPIER: Nuevo total: $contCru
			done
		fi
	fi
fi

if [ $contCru -lt 22 ];then
	if [ $contCru -eq $contJug ];then
		echo Tenemos un empate!
	elif [ $contCru -gt $contJug ];then
		echo Te ha ganado el CRUPIER! Y pierdes tu dinero...
	else
		echo Ha ganado el jugador!
	fi
else
	echo Ha ganado el jugador!
fi
echo JUGADOR: Valor total: $contJug
echo CRUPIER: Valor total: $contCru
