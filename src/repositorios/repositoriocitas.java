
package repositorios;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import clases.citas;
import proyecto.conexion;

/**
 *
 * @author usuario
 */
public class repositoriocitas {
    
    conexion con=new conexion();
     Connection conex=con.conexion();
     //guardar
      public void guardar(citas cit){
          PreparedStatement pstm = null;
        try{
              pstm = conex.prepareStatement("INSERT INTO citas(fecha,hora,paciente,cedula,precio,id_especialidad,id_medico )VALUES(?,?,?,?,?,?,?)");          
              pstm.setDate(1,cit.getFecha());
              pstm.setString(2, cit.getHora());
              pstm.setString(3, cit.getPaciente().getNombres()); 
              pstm.setString(4, cit.getPaciente().getCedula());
              pstm.setString(5, cit.getPrecio());
              pstm.setInt(6, cit.getEspecialidad().getId_especialidad());
              pstm.setInt(7, cit.getMedico().getId_medico());
              pstm.executeUpdate();
              JOptionPane.showMessageDialog(null,"registro grabado exitosamente");
              
            }catch (SQLException exc){
                 System.out.println("Error: " + exc.getMessage() );
                 System.out.println(exc.getMessage());
        }
      }
      
      //eliminar
      public void elimimar (int id){
          PreparedStatement pst = null;
        try{
            pst = conex.prepareStatement("delete from citas where id_citas=?");
            pst.setInt(1, id);
            
            JOptionPane.showMessageDialog(null,"registro elimidado exitosamente");
            
            pst.executeQuery();
        }catch(SQLException exc){
            System.out.println(exc.getMessage());
        }
      }
      
      //modificar
      public void modificar(String cedula, citas cit ){
          PreparedStatement pst = null;
        try{
            pst=conex.prepareStatement("update citas set fecha=?,hora=? where id_citas=?");
             
              pst.setDate(1, cit.getFecha());
              pst.setString(2, cit.getHora());

              pst.executeUpdate();
              JOptionPane.showMessageDialog(null,"registro grabado exitosamente");
              
        }catch(SQLException exc){
            System.out.println(exc.getMessage());
        }   
      }
}
