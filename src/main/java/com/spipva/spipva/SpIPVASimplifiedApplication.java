package com.spipva.spipva;

import com.spipva.spipva.dtos.IPVAPaymentDTO;
import com.spipva.spipva.exceptions.CarEndPlateException;
import com.spipva.spipva.services.impl.IPVAServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Aplicação de exemplo para data de pagamento do IPVA.
 * Esta aplicação utiliza a interface gráfica Swing para exibir os resultados.
 *
 * @Author: Gustavo Toledo
 */
public class SpIPVASimplifiedApplication extends JPanel {

    public SpIPVASimplifiedApplication(IPVAPaymentDTO ipvaPaymentDTO) {
        setLayout(new GridLayout(4, 3));

        JLabel objectNameLabel = new JLabel("Final da Placa:");
        JLabel objectNameValue = new JLabel(ipvaPaymentDTO.getCarPlateEnd());
        JLabel paymentValueLabel = new JLabel("Data para pagamento do IPVA:");
        JLabel paymentValueValue = new JLabel(String.valueOf(ipvaPaymentDTO.getPaymentDate()));

        add(objectNameLabel);
        add(objectNameValue);
        add(paymentValueLabel);
        add(paymentValueValue);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("IPVA Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel objectNameLabel = new JLabel("Final da Placa:");
        JTextField objectNameField = new JTextField(15);
        JButton submitButton = new JButton("Calcular Data de Pagamento");

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(objectNameLabel, gbc);

        gbc.gridx = 1;
        frame.add(objectNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String objectName = objectNameField.getText();

                try {
                    IPVAServiceImpl ipvaService = new IPVAServiceImpl();
                    IPVAPaymentDTO ipvaPaymentDTO = ipvaService.payIPVA(objectName);

                    JFrame outputFrame = new JFrame("IPVA Output");
                    outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    outputFrame.add(new SpIPVASimplifiedApplication(ipvaPaymentDTO));
                    outputFrame.pack();
                    outputFrame.setVisible(true);
                } catch (CarEndPlateException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}