# Questão 1: State

## Visão Geral
O padrão State gerencia o comportamento da classe BoletimProva durante as fases da prova de orientação. 

## Participantes

## EstadoProva (Interface do Estado)

- Define os métodos que representam ações possíveis: registrarLargada, registrarChegada, registrarPassagem, registrarAtraso.
- Permite que cada fase da prova tenha sua própria lógica.

## BoletimProva (Contexto)

- Mantém uma referência ao estado atual da prova (EstadoProva).
- Delega o comportamento (registrar largada, passagem, etc.) para o estado atual.
- Transita entre os estados com métodos como apresentarPraLargada() e registrarLargada().

## States Concretos

- EstadoPreProva: Nenhuma ação é permitida. Estado inicial da prova.

- EstadoMomentoLargada: Apenas registro de atraso é permitido. Transição para Pista ocorre ao registrar a largada.

- EstadoPista: Permite registrar atraso, passagens e chegada. Transição automática para Pós-Prova após chegada.

- EstadoPosProva: Apenas o registro de atraso ainda é permitido. Nenhuma outra ação é válida após a chegada.

## Porque State?

- Encapsulamento de regras: Cada fase sabe o que pode ou não pode fazer
- Evita ifs e switchs: Nada de if (fase == X) em todo lugar
- Open/Closed Principle: Pode criar novos estados sem mexer nos antigos
- Transições claras:	Mudanças de fase feitas de forma controlada
- Alta coesão:	Cada classe trata de uma única responsabilidade

# Questão 2: Chain of Responsibility

## Visão Geral
O padrão Chain of Responsibility gerencia a apuração de resultados de provas de orientação através de múltiplas validações sequenciais.

## Participantes

### ApuradorHandler (Handler Abstrato)
- Define a interface comum e implementa o encadeamento
- Coordena o processamento através do método `apurar()`
- Delega a lógica específica para o método abstrato `apurarRegra()`
- os dois métodos acima tambem fazem parte de um themplate method

### RequisicaoApuracao (Request)
- Encapsula os dados da apuração (BoletimProva, tempoMaximo, tempoProva)
- Transporta informações através da cadeia de handlers

### Handlers Concretos
- **ApuradorRegistroChegada**: Verifica se há registro de chegada
- **ApuradorOrdemPassagem**: Valida ordem correta dos prismas
- **ApuradorTotalidadePrismas**: Confirma registro de todos os prismas
- **ApuradorTempoAtraso**: Aplica penalização por atraso
- **ApuradorTempoMaximo**: Verifica se não excedeu tempo limite

## Por que Chain of Responsibility?

- **Separação de responsabilidades**: Cada validação isolada em sua classe
- **Flexibilidade**: Fácil reordenar ou modificar a cadeia
- **Extensibilidade**: Adicionar novas regras sem alterar código existente
- **Processamento sequencial**: Natural para validações interdependentes
- **Reutilização**: Handlers podem ser recombinados para diferentes cenários
