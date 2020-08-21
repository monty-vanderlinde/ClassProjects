using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assignment2CSharp
{
    public partial class Form2 : Form
    {
        private Form1 parentForm = new Form1();
        
        public Form2(String firstName, String lastName, String phoneNumber, int numberPanels, decimal deposit, bool expressInstall, Form1 form)
        {
            InitializeComponent();
            this.FormBorderStyle = FormBorderStyle.FixedDialog;
            performCalculations(firstName, lastName, phoneNumber, numberPanels, deposit, expressInstall);
            parentForm = form;
        }

        private void performCalculations(String firstName, String lastName, String phoneNumber, int numberPanels, decimal deposit, bool expressInstall)
        {
            // do the calculations
            decimal baseCost = 2000.00M;

            decimal additionalPanelCost = (numberPanels - 2) * 300.00M;

            decimal totalCost = baseCost + additionalPanelCost;
            if (expressInstall)
                totalCost *= 1.05M;
            
            decimal balanceDue = totalCost - deposit;

            bool refundNeeded = (balanceDue < 0.00M);

            fillOutForm(firstName, lastName, phoneNumber, numberPanels, baseCost, additionalPanelCost, totalCost, deposit, balanceDue, refundNeeded, expressInstall);
        }

        private void fillOutForm(String firstName, String lastName, String phoneNumber, int numberPanels, decimal baseCost, decimal additionalPanelCost, decimal totalCost, decimal deposit, decimal balanceDue, bool refundNeeded, bool expressInstall)
        {
            String s = firstName + " " + lastName + ", thank you for your order";
            if (expressInstall)
                s += " with express installation";
            s += "!";
            labelName.Text = s;

            labelPhone.Text = "If we have any issues, we will contact you at your phone number (" + phoneNumber + ").";

            if (numberPanels == 3)
                labelAdditionalPanels.Text = "1 Additional Panel Cost:";
            else
                labelAdditionalPanels.Text = (numberPanels - 2) + " Additional Panels Cost:";

            labelBaseCost.Text = "$" + baseCost;

            labelAdditionalCost.Text = "$" + additionalPanelCost;

            labelTotalCost.Text = "$" + totalCost;

            labelDeposit.Text = "$" + deposit;

            if (refundNeeded)
            {
                labelRefund.Text = "Refund:";
                balanceDue *= -1;
            }

            labelBalanceDue.Text = "$" + balanceDue;
        }

        private void buttonClose_Click(object sender, EventArgs e)
        {
            parentForm.closeForms();
        }

        private void buttonEditOrder_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void buttonNewOrder_Click(object sender, EventArgs e)
        {
            parentForm.emptyForm();
            this.Close();
        }
    }
}
