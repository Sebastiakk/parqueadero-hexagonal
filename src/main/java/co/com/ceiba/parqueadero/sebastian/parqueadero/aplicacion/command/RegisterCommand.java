package co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command;

import java.util.Date;

public class RegisterCommand {
        private long idCupo;
        private String placa;
        private Date horaEntrada;
        private Date horaSalida;
        private String tipoVehiculo;
        private int cilindraje;

        public RegisterCommand() {
        }

        public RegisterCommand(long idCupo, String placa, Date horaEntrada, Date horaSalida, String tipoVehiculo,
                        int cilindraje) {
                this.idCupo = idCupo;
                this.placa = placa;
                this.horaEntrada = horaEntrada;
                this.horaSalida = horaSalida;
                this.tipoVehiculo = tipoVehiculo;
                this.cilindraje = cilindraje;
        }

        public long getIdCupo() {
                return this.idCupo;
        }

        public void setIdCupo(long idCupo) {
                this.idCupo = idCupo;
        }

        public String getPlaca() {
                return this.placa;
        }

        public void setPlaca(String placa) {
                this.placa = placa;
        }

        public Date getHoraEntrada() {
                return this.horaEntrada;
        }

        public void setHoraEntrada(Date horaEntrada) {
                this.horaEntrada = horaEntrada;
        }

        public Date getHoraSalida() {
                return this.horaSalida;
        }

        public void setHoraSalida(Date horaSalida) {
                this.horaSalida = horaSalida;
        }

        public String getTipoVehiculo() {
                return this.tipoVehiculo;
        }

        public void setTipoVehiculo(String tipoVehiculo) {
                this.tipoVehiculo = tipoVehiculo;
        }

        public int getCilindraje() {
                return this.cilindraje;
        }

        public void setCilindraje(int cilindraje) {
                this.cilindraje = cilindraje;
        }

}
