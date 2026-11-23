import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TiketNeon extends JFrame implements ActionListener {

    // Tombol dibuat di atas supaya bisa dipakai di actionPerformed
    private JButton btnKeluar = new JButton("KELUAR");

    public TiketNeon() {
        super("NEON FEST 2026 - Tiket");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 420);
        setLocationRelativeTo(null);   // jendela muncul di tengah layar

        // ----- Warna tema neon -----
        Color warnaLatar = new Color(18, 10, 38);   // ungu sangat gelap
        Color warnaTiket = new Color(30, 18, 64);   // ungu gelap
        Color neonPink   = new Color(255, 64, 170);
        Color neonBiru   = new Color(0, 229, 255);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(warnaLatar);

        // ----- Data tiket -----
        String kode   = "NF-2026-0817";
        String nama   = "Tiha Nurra";
        String band   = "Neon Dreams";
        String jenis  = "VIP";
        String jumlah = "2 tiket";
        String total  = "Rp 1500000";

        // ----- Bagian atas (NORTH): judul -----
        JLabel lblJudul = new JLabel("NEON FEST 2026", JLabel.CENTER);
        lblJudul.setForeground(neonPink);

        JLabel lblSub = new JLabel("~ TIKET MASUK ~", JLabel.CENTER);
        lblSub.setForeground(Color.WHITE);

        JPanel panelJudul = new JPanel(new GridLayout(2, 1));
        panelJudul.setBackground(warnaLatar);
        panelJudul.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        panelJudul.add(lblJudul);
        panelJudul.add(lblSub);

        // ----- Bagian tengah (CENTER): isi tiket -----
        String isiTiket = "\n"
                + "  Kode Tiket  : " + kode + "\n\n"
                + "  Nama        : " + nama + "\n\n"
                + "  Band        : " + band + "\n\n"
                + "  Jenis Tiket : " + jenis + "\n\n"
                + "  Jumlah      : " + jumlah + "\n\n"
                + "  Total Bayar : " + total + "\n\n"
                + "  || ||| | |||| || ||| | ||||| || |||\n";

        JTextArea areaTiket = new JTextArea(isiTiket);
        areaTiket.setEditable(false);          // tidak bisa diketik user
        areaTiket.setBackground(warnaTiket);
        areaTiket.setForeground(Color.WHITE);

        // Kartu tiket dengan garis pink
        JPanel panelTiket = new JPanel(new BorderLayout());
        panelTiket.setBorder(BorderFactory.createLineBorder(neonPink, 2));
        panelTiket.add(areaTiket, BorderLayout.CENTER);

        // Pembungkus supaya tiket punya jarak dari tepi jendela
        JPanel panelTengah = new JPanel(new BorderLayout());
        panelTengah.setBackground(warnaLatar);
        panelTengah.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        panelTengah.add(panelTiket, BorderLayout.CENTER);

        // ----- Bagian bawah (SOUTH): tombol keluar -----
        btnKeluar.setBackground(warnaLatar);
        btnKeluar.setForeground(neonBiru);
        btnKeluar.addActionListener(this);   // daftarkan tombol ke event handling

        JPanel panelTombol = new JPanel();
        panelTombol.setBackground(warnaLatar);
        panelTombol.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 10));
        panelTombol.add(btnKeluar);

        // ----- Pasang semua panel ke frame -----
        getContentPane().add(panelJudul, BorderLayout.NORTH);
        getContentPane().add(panelTengah, BorderLayout.CENTER);
        getContentPane().add(panelTombol, BorderLayout.SOUTH);
    }

    // Dijalankan saat tombol diklik
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnKeluar) {
            System.exit(0);   // menutup program
        }
    }

    public static void main(String[] args) {
        TiketNeon tampilan = new TiketNeon();
        tampilan.setVisible(true);
    }
}
