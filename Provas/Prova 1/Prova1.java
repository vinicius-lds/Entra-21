import javax.swing.JOptionPane;

public class Prova1 {

    public static void main(String[] args) {
        
        String nome = JOptionPane.showInputDialog(null, "Insira o nome do funcionário. Ou digite \"SAIR\" para ecncerrar o programa.");
        String cargo, sexo;
        String nomeMaiorSalario = "", nomeMenorSalario = "";
        double maiorSalario = 0.0, menorSalario = 0.0;
        int idade = -1, faltas = -1, filhos = -1, funcionarios = 0, masc = 0, faxa1 = 0, faxa2 = 0, faxa3 = 0, faxa4 = 0, qtdClubeFidelidade = 0;;
        int desJavaJr = 0, desJavaPleno = 0, desJavaSenior = 0, admBD = 0, analistaJr = 0, analistaPleno = 0, analistaSenior = 0, arqSoftware = 0, gerProjetos = 0;
        boolean isAssociado;
        double salarioBase, salarioBruto, salarioLiquido, hora50 = -1, hora100 = -1;

        while(!nome.equals("SAIR")) {
            
            cargo = (String) JOptionPane.showInputDialog(null, "Cargo", "", JOptionPane.PLAIN_MESSAGE, null,
                                                        new String[]{"Desenvolvedor Java Júnior", 
                                                                     "Desenvolvedor Java Pleno", 
                                                                     "Desenvolvedor Java Sênior", 
                                                                     "Administrador de Banco de Dados",
                                                                     "Analista Júnior",
                                                                     "Analista Pleno",
                                                                     "Analista Sênior",
                                                                     "Arquiteto de Software",
                                                                     "Gerente de Projetos"},
                                                        "");
            
            switch (cargo) {
                case "Desenvolvedor Java Júnior":
                    desJavaJr++;
                    salarioBase = 1450;
                    break;
                case "Desenvolvedor Java Pleno":
                    desJavaPleno++;
                    salarioBase = 2220;
                    break;
                case "Desenvolvedor Java Sênior":
                    desJavaSenior++;
                    salarioBase = 3300;
                    break;
                case "Administrador de Banco de Dados":
                    admBD++;
                    salarioBase = 3560.0;
                    break;
                case "Analista Júnior":
                    analistaJr++;
                    salarioBase = 2800.0;
                    break;
                case "Analista Pleno":
                    analistaPleno++;
                    salarioBase = 3400.0;
                    break;
                case "Analista Sênior":
                    analistaSenior++;
                    salarioBase = 4500.0;
                    break;
                case "Arquiteto de Software":
                    arqSoftware++;
                    salarioBase = 5280.0;
                    break;
                case "Gerente de Projetos":
                    gerProjetos++;
                    salarioBase = 6000.0;
                    break;
                default:
                    salarioBase = 0.0;
                    break;
            }

            while(hora50 < 0) {
                try {
                    hora50 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de hora extra com 50% de acréscimo."));
                    if(hora50 < 0) {
                        JOptionPane.showMessageDialog(null, "Esta quantidade de horas não é válida!");
                    }
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Esta quantidade de horas não é válida!");
                }
            }

            while(hora100 < 0) {
                try {
                    hora100 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de hora extra com 100% de acréscimo."));
                    if(hora100 < 0) {
                        JOptionPane.showMessageDialog(null, "Esta quantidade de horas não é válida!");
                    }
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Esta quantidade de horas não é válida!");
                }
            }

            sexo = (String) JOptionPane.showInputDialog(null, 
                                               "Sexo", 
                                               "", 
                                               JOptionPane.PLAIN_MESSAGE, 
                                               null,
                                               new String[]{"Masculino", "Feminino"},
                                               "");
            if(sexo.equals("Masculino")) {
                masc++;
            }                                   

            while(idade < 18) {
                try {
                    idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a idade do funcionário"));
                    if(idade < 18) {
                        JOptionPane.showMessageDialog(null, "Esta idade é inválida!");
                    }
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Esta idade é inválida!");
                }
            }

            if(idade < 27) {
                faxa1++;
            } else if(idade < 41) {
                faxa2++;
            } else if(idade < 51) {
                faxa3++;
            } else {
                faxa4++;
            }

            while(faltas < 0) {
                try {
                    faltas = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o número de faltas que este funcionário acumulou."));
                    if(faltas < 0) {
                        JOptionPane.showMessageDialog(null, "Essa número de faltas é inválido!");
                    }
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Essa número de faltas é inválido!");
                }
            }

            while(filhos < 0) {
                try {
                    filhos = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o número de filhos que este funcionário tem."));
                    if(filhos < 0) {
                        JOptionPane.showMessageDialog(null, "Essa número de filhos é inválido!");
                    }
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Essa número de filhos é inválido!");
                }
            }

            isAssociado = (JOptionPane.showInputDialog(null, 
                                                        "Esse funcionario é associado ao clube de fidelidade.", 
                                                        "", 
                                                        JOptionPane.PLAIN_MESSAGE, 
                                                        null,
                                                        new String[]{"Sim", "Não"},
                                                        "").equals("Sim")) ? true : false;

            if(isAssociado) {
                qtdClubeFidelidade++;
            }                                            
            
            //calculo do valor das horas extras
            hora50 = ((salarioBase / 160) * hora50) + ((salarioBase / 160) * hora50) * 0.5;
            hora100 = ((salarioBase / 160) * hora100) * 2;

            //salario + hora extra
            salarioBruto = salarioBase + (hora50 + hora100);

            if(salarioBruto <= 2000) {
                salarioLiquido = salarioBruto - (salarioBruto * 0.05);
            } else if(salarioBruto <= 3500) {
                salarioLiquido = salarioBruto - (salarioBruto * 0.07);
            } else if(salarioBruto <= 5600) {
                salarioLiquido = salarioBruto - (salarioBruto * 0.08);
            } else {
                salarioLiquido = salarioBruto - (salarioBruto * 0.1);
            }

            //VT
            salarioLiquido -= (salarioBase * 0.06);

            if(faltas == 0) {
                salarioLiquido += 200;
            }          

            salarioLiquido += (filhos * 50);          

            if(isAssociado) {
                salarioLiquido -= 110;
            }

            JOptionPane.showMessageDialog(null, "Salário Liquído do funcionário: " + salarioLiquido);

            if(salarioLiquido > maiorSalario) {
                maiorSalario = salarioLiquido;
                nomeMaiorSalario = nome;
            }

            if(salarioLiquido < menorSalario) {
                menorSalario = salarioLiquido;
                nomeMenorSalario = nome;
            }

            if((menorSalario == 0.0) && (maiorSalario == 0.0)) {
                maiorSalario = salarioLiquido;
                menorSalario = salarioLiquido;
                nomeMaiorSalario = nome;
                nomeMenorSalario = nome;
            }


            nome = JOptionPane.showInputDialog(null, "Insira o nome do funcionário. Ou digite \"SAIR\" para ecncerrar o programa.");
            hora50 = -1; 
            hora100 = -1;
            idade = -1;
            faltas = -1;
            filhos = -1;
            funcionarios++;
        }

        JOptionPane.showMessageDialog(null, "Número de funcionários cadastrados: " + funcionarios);

        JOptionPane.showMessageDialog(null, funcionarios - masc + " mulheres (" + (((funcionarios - masc) / funcionarios) * 100) + ")\n"
                                          + masc + " homens + (" + ((masc / funcionarios) * 100));

        JOptionPane.showMessageDialog(null, "funcionários com idade entre 18 a 26 anos: " + faxa1
                                            + "\nfuncionários com idade entre 27 a 40 anos: " + faxa2
                                            + "\nfuncionários com idade entre 41 a 50 anos: " + faxa3
                                            + "\nfuncionários com idade acima de 50 anos: " + faxa4);       
        
        JOptionPane.showMessageDialog(null, "Desenvolvedor Java Júnior: " + desJavaJr + " funcionarios " + ((desJavaJr / funcionarios) * 100)
                                            + "\nDesenvolvedor Java Pleno: " + desJavaPleno + " funcionarios " + ((desJavaPleno / funcionarios) * 100)
                                            + "\nDesenvolvedor Java Senior: " + desJavaSenior + " funcionarios " + ((desJavaSenior / funcionarios) * 100)
                                            + "\nAdministrador de Banco de Dados: " + admBD + " funcionarios " + ((admBD / funcionarios) * 100)
                                            + "\nAnalista Júnior: " + analistaJr + " funcionarios " + ((analistaJr / funcionarios) * 100)
                                            + "\nAnalista Pleno: " + analistaPleno + " funcionarios " + ((analistaPleno / funcionarios) * 100)
                                            + "\nAnalista Sênior : " + analistaSenior + " funcionarios " + ((analistaSenior / funcionarios) * 100)
                                            + "\nArquiteto de Software: " + arqSoftware + " funcionarios " + ((arqSoftware / funcionarios) * 100)
                                            + "\nGerente de Projetos: " + gerProjetos + " funcionarios " + ((gerProjetos / funcionarios) * 100));

        if(funcionarios == 1) {
            JOptionPane.showMessageDialog(null, "Foi cadastrado somente um funcionario: " + nomeMaiorSalario + " R$" + maiorSalario);
        } else {
            JOptionPane.showMessageDialog(null, "Funcionario com maior salario liquido: " + nomeMaiorSalario + " R$" + maiorSalario
                                            + "Funcionario com menor salario liquido: " + nomeMenorSalario + " R$" + menorSalario);    
        }

        JOptionPane.showMessageDialog(null, qtdClubeFidelidade + " funcionario aderem ao clube fidelidade.");
    
    }

}