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