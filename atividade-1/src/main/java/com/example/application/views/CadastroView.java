package com.example.application.views;

import com.example.application.models.Apartamento;
import com.example.application.models.Edificio;
import com.example.application.models.Morador;
import com.example.application.repositories.ApartamentoRepository;
import com.example.application.repositories.EdificioRepository;
import com.example.application.repositories.MoradorRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("cadastro")
public class CadastroView extends VerticalLayout {

    private final EdificioRepository edificioRepository;
    private final ApartamentoRepository apartamentoRepository;
    private final MoradorRepository moradorRepository;

    private TextField edificioNome;
    private TextField edificioEndereco;
    private TextField apartamentoNumero;
    private TextField apartamentoAndar;
    private TextField apartamentoMetragem;
    private TextField apartamentoSituacao;
    private TextField moradorNome;
    private TextField moradorCPF;
    private TextField moradorTelefone;

    @Autowired
    public CadastroView(EdificioRepository edificioRepository,
                        ApartamentoRepository apartamentoRepository,
                        MoradorRepository moradorRepository) {
        this.edificioRepository = edificioRepository;
        this.apartamentoRepository = apartamentoRepository;
        this.moradorRepository = moradorRepository;

        createForm();

        Button cadastrarButton = new Button("Cadastrar");
        cadastrarButton.addClickListener(e -> cadastrar());
        add(cadastrarButton);
    }

    private void createForm() {
        FormLayout formLayout = new FormLayout();

        edificioNome = new TextField("Nome do Edifício");
        edificioEndereco = new TextField("Endereço do Edifício");
        formLayout.add(edificioNome, edificioEndereco);

        apartamentoNumero = new TextField("Número do Apartamento");
        apartamentoAndar = new TextField("Andar do Apartamento");
        apartamentoMetragem = new TextField("Metragem do Apartamento");
        apartamentoSituacao = new TextField("Situação do Apartamento");
        formLayout.add(apartamentoNumero, apartamentoAndar, apartamentoMetragem, apartamentoSituacao);

        moradorNome = new TextField("Nome do Morador");
        moradorCPF = new TextField("CPF do Morador");
        moradorTelefone = new TextField("Telefone do Morador");
        formLayout.add(moradorNome, moradorCPF, moradorTelefone);

        add(formLayout);
    }

    private void cadastrar() {
        Edificio edificio = new Edificio();
        edificio.setNome(edificioNome.getValue());
        edificio.setEndereco(edificioEndereco.getValue());

        edificioRepository.save(edificio);

        Apartamento apartamento = new Apartamento();
        apartamento.setNumero(Integer.parseInt(apartamentoNumero.getValue()));
        apartamento.setAndar(Integer.parseInt(apartamentoAndar.getValue()));
        apartamento.setMetragem(Double.parseDouble(apartamentoMetragem.getValue()));
        apartamento.setSituacao(apartamentoSituacao.getValue());

        apartamentoRepository.save(apartamento);

        Morador morador = new Morador();
        morador.setNome(moradorNome.getValue());
        morador.setCpf(moradorCPF.getValue());
        morador.setTelefone(moradorTelefone.getValue());

        moradorRepository.save(morador);

        // Lógica adicional, como atualizar a tabela exibida na view ou exibir uma mensagem de sucesso
        Notification.show("Cadastro realizado com sucesso!")
                .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        limparCampos();
    }

    private void limparCampos() {
        edificioNome.clear();
        edificioEndereco.clear();
        apartamentoNumero.clear();
        apartamentoAndar.clear();
        apartamentoMetragem.clear();
        apartamentoSituacao.clear();
        moradorNome.clear();
        moradorCPF.clear();
        moradorTelefone.clear();
    }
}