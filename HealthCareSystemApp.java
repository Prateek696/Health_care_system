import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class HealthCareSystemApp {
    public static void main(String[] args) {
        // Launch the main dashboard
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }
}

// Dashboard Interface
class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Community Health Care System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creating a main panel with grid layout
        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        // Add navigation buttons
        JButton registerButton = new JButton("Register Patient");
        JButton checkupButton = new JButton("Health Checkup");
        JButton historyButton = new JButton("Medical History");
        JButton appointmentsButton = new JButton("Appointments");
        JButton feedbackButton = new JButton("Feedback");
        JButton reportButton = new JButton("Generate Health Report");

        // Add action listeners for each button to navigate to different modules
        registerButton.addActionListener(e -> new RegistrationWindow());
        checkupButton.addActionListener(e -> new HealthCheckupWindow());
        historyButton.addActionListener(e -> new MedicalHistoryWindow());
        appointmentsButton.addActionListener(e -> new AppointmentsWindow());
        feedbackButton.addActionListener(e -> new FeedbackWindow());
        reportButton.addActionListener(e -> new HealthReportWindow());

        // Adding buttons to main panel
        mainPanel.add(registerButton);
        mainPanel.add(checkupButton);
        mainPanel.add(historyButton);
        mainPanel.add(appointmentsButton);
        mainPanel.add(feedbackButton);
        mainPanel.add(reportButton);

        add(mainPanel);
    }
}

// Registration Window
class RegistrationWindow extends JFrame {
    private JTextField nameField, ageField;
    private JComboBox<String> genderBox, issueBox;

    public RegistrationWindow() {
        setTitle("Patient Registration");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Gender:"));
        genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        panel.add(genderBox);

        panel.add(new JLabel("Health Issues:"));
        issueBox = new JComboBox<>(new String[]{"None", "Diabetes", "Hypertension", "Asthma", "Heart Issues"});
        panel.add(issueBox);

        JButton submitButton = new JButton("Register");
        panel.add(submitButton);

        submitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Registration Complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
            String reviewText = "Patient Registered:\nName: " + nameField.getText() + "\nAge: " + ageField.getText() +
                                "\nGender: " + genderBox.getSelectedItem() + "\nHealth Issues: " + issueBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, reviewText, "Registration Review", JOptionPane.INFORMATION_MESSAGE);
        });
        
        add(panel);
        setVisible(true);
    }

    public String getIssue() {
        return (String) issueBox.getSelectedItem();
    }
}

// Health Checkup Window
class HealthCheckupWindow extends JFrame {
    public HealthCheckupWindow() {
        setTitle("Health Checkup");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        
        panel.add(new JLabel("Symptoms:"));
        JTextField symptomsField = new JTextField();
        panel.add(symptomsField);

        panel.add(new JLabel("Duration of Symptoms:"));
        JTextField durationField = new JTextField();
        panel.add(durationField);

        JButton checkupButton = new JButton("Start Checkup");
        panel.add(checkupButton);

        checkupButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Health Checkup Started!", "Success", JOptionPane.INFORMATION_MESSAGE);
            String reviewText = "Health Checkup Details:\nSymptoms: " + symptomsField.getText() +
                                "\nDuration: " + durationField.getText();
            JOptionPane.showMessageDialog(this, reviewText, "Checkup Review", JOptionPane.INFORMATION_MESSAGE);
        });

        add(panel);
        setVisible(true);
    }
}

// Medical History Window
class MedicalHistoryWindow extends JFrame {
    public MedicalHistoryWindow() {
        setTitle("Medical History");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Displaying Medical History..."));
        
        // Placeholder for future functionality.
        
        add(panel);
        setVisible(true);
    }
}

// Appointments Window
class AppointmentsWindow extends JFrame {
    public AppointmentsWindow() {
        setTitle("Appointments");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Date section
        JLabel dateLabel = new JLabel("Date (DD/MM/YYYY):");
        JTextField dateField = new JTextField();
        panel.add(dateLabel);
        panel.add(dateField);

        // Time section
        JLabel timeLabel = new JLabel("Time (HH:MM):");
        JTextField timeField = new JTextField();
        panel.add(timeLabel);
        panel.add(timeField);

        // Doctor section
        JLabel doctorLabel = new JLabel("Doctor's Name:");
        JTextField doctorField = new JTextField();
        panel.add(doctorLabel);
        panel.add(doctorField);

        // Submit button
        JButton scheduleButton = new JButton("Schedule Appointment");
        panel.add(scheduleButton);

        scheduleButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Appointment Scheduled!", "Success", JOptionPane.INFORMATION_MESSAGE);
            String reviewText = "Appointment Scheduled:\nDate: " + dateField.getText() +
                                "\nTime: " + timeField.getText() + "\nDoctor: " + doctorField.getText();
            JOptionPane.showMessageDialog(this, reviewText, "Appointment Review", JOptionPane.INFORMATION_MESSAGE);
        });

        add(panel);
        setVisible(true);
    }
}

// Feedback Window
class FeedbackWindow extends JFrame {
    public FeedbackWindow() {
        setTitle("Feedback");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        panel.add(new JLabel("Provide your Feedback:"));
        JTextArea feedbackArea = new JTextArea(5, 20);
        panel.add(new JScrollPane(feedbackArea));

        JButton submitButton = new JButton("Submit Feedback");
        panel.add(submitButton);

        submitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Feedback Submitted!", "Success", JOptionPane.INFORMATION_MESSAGE);
            String reviewText = "Your Feedback:\n" + feedbackArea.getText();
            JOptionPane.showMessageDialog(this, reviewText, "Feedback Review", JOptionPane.INFORMATION_MESSAGE);
        });

        add(panel);
        setVisible(true);
    }
}

// Health Report Window
class HealthReportWindow extends JFrame {
    public HealthReportWindow() {
        setTitle("Health Report");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JButton generateReportButton = new JButton("Generate Random Health Report");
        JTextArea reportArea = new JTextArea(10, 30);
        reportArea.setEditable(false);

        generateReportButton.addActionListener(e -> {
            String report = generateHealthReport();
            reportArea.setText(report);
        });

        panel.add(generateReportButton);
        panel.add(new JScrollPane(reportArea));
        add(panel);
        setVisible(true);
    }

    private String generateHealthReport() {
        String[] results = {"Healthy", "Not Healthy"};
        String[] tests = {"Blood Pressure", "Blood Sugar", "Cholesterol"};
        Random random = new Random();
        StringBuilder report = new StringBuilder("Health Report:\n");

        for (String test : tests) {
            report.append(test).append(" Result: ").append(random.nextInt(140) + 60).append("\n");
        }

        String healthStatus = results[random.nextInt(results.length)];
        report.append("Overall Health Status: ").append(healthStatus).append("\n");

        if ("Not Healthy".equals(healthStatus)) {
            report.append("Recommended Medicine: Med-").append(random.nextInt(900) + 100);
        }
        return report.toString();
    }
}
