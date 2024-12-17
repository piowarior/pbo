public class Main {
    public static void main(String[] args) {
        // Membuat objek Encyclopedia
        Encyclopedia encyclopedia = new Encyclopedia(
            "Ilmu Pengetahuan Alam",   // title
            false,                     // borrowed_status
            "",                        // date_borrowed
            "",                        // due_date
            "Budi Darmawan",           // author
            "Penerbit Ilmu Jaya",      // publisher
            "Pendidikan",              // category
            123456789,                 // isbn
            5,                         // volume
            2                          // edition
        );

        // Mencetak atribut dari objek Encyclopedia
        System.out.println("Title   : " + encyclopedia.getTitle());
        System.out.println("Author  : " + encyclopedia.getAuthor());
        System.out.println("ISBN    : " + encyclopedia.getIsbn());
        System.out.println("Volume  : " + encyclopedia.getVolume());
    }
}