using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace GamingArt
{
    public partial class frmArt : Form
    {
        public frmArt()
        {
            InitializeComponent();
        }

        private void artistBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.artistBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.artDataSet);

        }

        private void frmArt_Load(object sender, EventArgs e)
        {
            this.artistTableAdapter.Fill(this.artDataSet.Artist);
            this.artistTableAdapter.Dispose();

        }

        private void btnValue_Click(object sender, EventArgs e)
        {
            decimal totalValue = 0;

            foreach (DataRow row in this.artDataSet.Tables["Artist"].Rows)
            {
                totalValue += Convert.ToDecimal(row["Retail Price"]);
            }

            this.lblTotalRetailValue.Text = "The total retail value is $" + totalValue.ToString("#,##0.00");
            this.lblTotalRetailValue.Visible = true;
        }
    }
}
