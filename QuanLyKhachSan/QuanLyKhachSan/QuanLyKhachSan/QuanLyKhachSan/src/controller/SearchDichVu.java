package controller;

import dao.DichVuDAO;
import java.util.ArrayList;
import model.DichVu;

//
public class SearchDichVu {

    public static SearchDichVu getInstance() {
        return new SearchDichVu();
    }

    public ArrayList<DichVu> searchTatCa(String text) {
        ArrayList<DichVu> result = new ArrayList<>();
        ArrayList<DichVu> armt = DichVuDAO.getInstance().selectAllExist();
        for (var mt : armt) {
           
                if (mt.getMaDichVu().toLowerCase().contains(text.toLowerCase()) || mt.getTenDichVu().toLowerCase().contains(text.toLowerCase()))
                      
                    result.add(mt);
                
            
        }
        return result;
    
}

    


    public ArrayList<DichVu> searchSoLuong(String text) {
        ArrayList<DichVu> result = new ArrayList<>();
       ArrayList<DichVu> armt = DichVuDAO.getInstance().selectAllExist();
       for (var mt : armt) {
               if (text.length() != 0) {
                   if (mt.getSoLuong() > Integer.parseInt(text)) {
                       result.add(mt);
                   }
               } else {
                    result.add(mt);
               }
           }        
        return null;
  }
//        ArrayList<DichVu> result = new ArrayList<>();
//       ArrayList<DichVu> armt = DichVuDAO.getInstance().selectAllExist();
//       for (var mt : armt) {
//        
//               if (text.length() != 0) {
//                   if (mt.getSoLuong() > Integer.parseInt(text)) {
//                       result.add(mt);
//                   }
//               } else {
//                    result.add(mt);
//               }
//           }        
//       }
//        return result;
   
    public ArrayList<DichVu> searchDonGia(String text) {
        ArrayList<DichVu> result = new ArrayList<>();
        ArrayList<DichVu> armt = DichVuDAO.getInstance().selectAllExist();
        for (var mt : armt) {
                if (text.length() != 0) {
                    if (mt.getGia() > Integer.parseInt(text)) {
                        result.add(mt);
                    }
                }
                else {
                    result.add(mt);
                }
            } 
        return result;
    }



  public DichVu searchId(String text) {
        DichVu result = new DichVu();
        ArrayList<DichVu> armt = DichVuDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getMaDichVu().toLowerCase().contains(text.toLowerCase())) {
                return mt;
            }
        }
        return null;
    }
}

