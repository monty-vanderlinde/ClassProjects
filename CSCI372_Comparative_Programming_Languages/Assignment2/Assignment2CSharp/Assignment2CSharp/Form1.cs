using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;
using System.Windows.Forms;
using System.Text.RegularExpressions;

namespace Assignment2CSharp
{
    public partial class Form1 : Form
    {
        private Form2 childForm;

        public Form1()
        {
            InitializeComponent();
            this.FormBorderStyle = FormBorderStyle.FixedDialog;
        }

        private void buttonSubmit_Click(object sender, EventArgs e)
        {
            String firstName, lastName, phoneNumber, numberPanels, deposit;
            int numberPanelsInt = 0;
            decimal depositDecimal = 0.00M;
            bool expressInstall;

            bool errorFlag = true;

            //check for errors with first name
            labelErrorFirstName.Text = "";
            firstName = textBoxFirstName.Text.Replace(" ", "");
            if (firstName.Equals(""))
            {
                errorFlag = false;
                labelErrorFirstName.Text = "Please enter a first name";
            }

            //check for errors with last name
            labelErrorLastName.Text = "";
            lastName = textBoxLastName.Text.Replace(" ", "");
            if (lastName.Equals(""))
            {
                errorFlag = false;
                labelErrorLastName.Text = "Please enter a last name";
            }

            //check for errors with phone number
            labelErrorPhoneNumber.Text = "";
            phoneNumber = textBoxPhoneNumber.Text.Replace(" ", "");
            Match phoneMatch = Regex.Match(phoneNumber, @"^[0-9-]*$");
            if (phoneNumber.Equals(""))
            {
                errorFlag = false;
                labelErrorPhoneNumber.Text = "Please enter a phone number";
            }
            if (!phoneMatch.Success)
            {
                errorFlag = false;
                labelErrorPhoneNumber.Text = "Please only include numbers (0-9) and dashes (-)";
            }

            //check for errors with number of panels
            labelErrorNumberPanels.Text = "";
            numberPanels = textBoxNumberPanels.Text.Replace(" ", "");
            if (numberPanels.Equals(""))
            {
                errorFlag = false;
                labelErrorNumberPanels.Text = "Please enter a number of panels";
            }
            else if(!Int32.TryParse(numberPanels, out numberPanelsInt))
            {
                errorFlag = false;
                labelErrorNumberPanels.Text = "Please only enter digits (0-9)";
            }
            else if(numberPanelsInt < 2)
            {
                errorFlag = false;
                labelErrorNumberPanels.Text = "Please enter a number greater than or equal to 2";
            }
            else if (numberPanelsInt > 1000)
            {
                errorFlag = false;
                labelErrorNumberPanels.Text = "Please enter a number less than or equal to 1,000";
            }

            //check for errors with deposit
            labelErrorDeposit.Text = "";
            deposit = textBoxDeposit.Text.Replace(" ", "");
            if (deposit.Equals(""))
            {
                errorFlag = false;
                labelErrorDeposit.Text = "Please enter a deposit number (0 if not giving a deposit)";
            }
            else if(!Decimal.TryParse(deposit, out depositDecimal))
            {
                errorFlag = false;
                labelErrorDeposit.Text = "Please enter a dollar amount without ($) or (,) like 1000.00";
            }

            expressInstall = checkBoxExpressInstall.Checked;

            //perform calculations if no errors were found
            if (errorFlag)
                displayChildForm(firstName, lastName, phoneNumber, numberPanelsInt, depositDecimal, expressInstall);
        }

        private void displayChildForm(String firstName, String lastName, String phoneNumber, int numberPanels, decimal deposit, bool expressInstall)
        {
            childForm = new Form2(firstName, lastName, phoneNumber, numberPanels, deposit, expressInstall, this);
            childForm.ShowDialog();
        }

        public void emptyForm()
        {
            textBoxFirstName.Text = "";
            textBoxLastName.Text = "";
            textBoxPhoneNumber.Text = "";
            textBoxNumberPanels.Text = "";
            textBoxDeposit.Text = "";
            checkBoxExpressInstall.Checked = false;
        }

        public void closeForms()
        {
            childForm.Close();
            this.Close();
        }
    }
}
