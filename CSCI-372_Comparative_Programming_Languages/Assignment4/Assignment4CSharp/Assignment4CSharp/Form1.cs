using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assignment4CSharp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void employeeBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.employeeBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.personnelDataSet);

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'personnelDataSet.Employee' table. You can move, or remove it, as needed.
            this.employeeTableAdapter.Fill(this.personnelDataSet.Employee);

        }

        private void btnPayRateAscending_Click(object sender, EventArgs e)
        {
            this.employeeDataGridView.Sort(this.employeeDataGridView.Columns[3], ListSortDirection.Descending);
        }

        private void btnPayRateDescending_Click(object sender, EventArgs e)
        {
            this.employeeDataGridView.Sort(this.employeeDataGridView.Columns[3], ListSortDirection.Ascending);
        }

        private void btnHighestPayRate_Click(object sender, EventArgs e)
        {
            var highest =
                from emp in personnelDataSet.Employee
                select emp.HourlyPayRate;

            decimal hPay = highest.First();

            foreach (var element in highest)
                if (element > hPay)
                    hPay = element;

            MessageBox.Show("The highest pay rate among the listed employees is $" + hPay);
        }

        private void btnLowestPayRate_Click(object sender, EventArgs e)
        {
            var lowest =
                from emp in personnelDataSet.Employee
                select emp.HourlyPayRate;

            decimal lPay = lowest.First();

            foreach (var element in lowest)
                if (element < lPay)
                    lPay = element;

            MessageBox.Show("The lowest pay rate among the listed employees is $" + lPay);
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            CurrencyManager currencyManager1 = (CurrencyManager)BindingContext[employeeDataGridView.DataSource];
            currencyManager1.SuspendBinding();

            foreach ( DataGridViewRow row in employeeDataGridView.Rows)
            {
                if ((row.Cells[1].Value != null) && (row.Cells[1].Value.ToString().ToLower().Contains(txtSearch.Text.ToLower())))
                    row.Visible = true;
                else
                    row.Visible = false;
            }
            
            currencyManager1.ResumeBinding();
        }

        private void btnReset_Click(object sender, EventArgs e)
        {
            this.employeeTableAdapter.Fill(this.personnelDataSet.Employee);
            this.employeeDataGridView.Sort(this.employeeDataGridView.Columns[0], ListSortDirection.Ascending);

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
