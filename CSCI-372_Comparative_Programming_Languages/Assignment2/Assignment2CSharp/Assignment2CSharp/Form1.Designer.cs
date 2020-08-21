namespace Assignment2CSharp
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.labelFirstName = new System.Windows.Forms.Label();
            this.labelLastName = new System.Windows.Forms.Label();
            this.labelPhoneNumber = new System.Windows.Forms.Label();
            this.labelNumberPanels = new System.Windows.Forms.Label();
            this.labelDeposit = new System.Windows.Forms.Label();
            this.checkBoxExpressInstall = new System.Windows.Forms.CheckBox();
            this.textBoxLastName = new System.Windows.Forms.TextBox();
            this.textBoxFirstName = new System.Windows.Forms.TextBox();
            this.textBoxPhoneNumber = new System.Windows.Forms.TextBox();
            this.textBoxNumberPanels = new System.Windows.Forms.TextBox();
            this.textBoxDeposit = new System.Windows.Forms.TextBox();
            this.buttonSubmit = new System.Windows.Forms.Button();
            this.labelErrorFirstName = new System.Windows.Forms.Label();
            this.labelErrorLastName = new System.Windows.Forms.Label();
            this.labelErrorPhoneNumber = new System.Windows.Forms.Label();
            this.labelErrorNumberPanels = new System.Windows.Forms.Label();
            this.labelErrorDeposit = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // labelFirstName
            // 
            this.labelFirstName.AutoSize = true;
            this.labelFirstName.Location = new System.Drawing.Point(12, 15);
            this.labelFirstName.Name = "labelFirstName";
            this.labelFirstName.Size = new System.Drawing.Size(60, 13);
            this.labelFirstName.TabIndex = 0;
            this.labelFirstName.Text = "First Name:";
            // 
            // labelLastName
            // 
            this.labelLastName.AutoSize = true;
            this.labelLastName.Location = new System.Drawing.Point(12, 41);
            this.labelLastName.Name = "labelLastName";
            this.labelLastName.Size = new System.Drawing.Size(61, 13);
            this.labelLastName.TabIndex = 1;
            this.labelLastName.Text = "Last Name:";
            // 
            // labelPhoneNumber
            // 
            this.labelPhoneNumber.AutoSize = true;
            this.labelPhoneNumber.Location = new System.Drawing.Point(12, 67);
            this.labelPhoneNumber.Name = "labelPhoneNumber";
            this.labelPhoneNumber.Size = new System.Drawing.Size(136, 13);
            this.labelPhoneNumber.TabIndex = 2;
            this.labelPhoneNumber.Text = "Phone Number (digits only):";
            // 
            // labelNumberPanels
            // 
            this.labelNumberPanels.AutoSize = true;
            this.labelNumberPanels.Location = new System.Drawing.Point(12, 92);
            this.labelNumberPanels.Name = "labelNumberPanels";
            this.labelNumberPanels.Size = new System.Drawing.Size(178, 13);
            this.labelNumberPanels.TabIndex = 3;
            this.labelNumberPanels.Text = "Number Of Panels (whole nuber 2+):";
            // 
            // labelDeposit
            // 
            this.labelDeposit.AutoSize = true;
            this.labelDeposit.Location = new System.Drawing.Point(12, 118);
            this.labelDeposit.Name = "labelDeposit";
            this.labelDeposit.Size = new System.Drawing.Size(170, 13);
            this.labelDeposit.TabIndex = 4;
            this.labelDeposit.Text = "Deposit (only numbers and period):";
            // 
            // checkBoxExpressInstall
            // 
            this.checkBoxExpressInstall.Location = new System.Drawing.Point(12, 141);
            this.checkBoxExpressInstall.Name = "checkBoxExpressInstall";
            this.checkBoxExpressInstall.Size = new System.Drawing.Size(191, 24);
            this.checkBoxExpressInstall.TabIndex = 5;
            this.checkBoxExpressInstall.Text = "Express Installation (+5% on total)";
            this.checkBoxExpressInstall.UseVisualStyleBackColor = true;
            // 
            // textBoxLastName
            // 
            this.textBoxLastName.Location = new System.Drawing.Point(196, 38);
            this.textBoxLastName.Name = "textBoxLastName";
            this.textBoxLastName.Size = new System.Drawing.Size(100, 20);
            this.textBoxLastName.TabIndex = 7;
            // 
            // textBoxFirstName
            // 
            this.textBoxFirstName.Location = new System.Drawing.Point(196, 12);
            this.textBoxFirstName.Name = "textBoxFirstName";
            this.textBoxFirstName.Size = new System.Drawing.Size(100, 20);
            this.textBoxFirstName.TabIndex = 6;
            // 
            // textBoxPhoneNumber
            // 
            this.textBoxPhoneNumber.Location = new System.Drawing.Point(196, 64);
            this.textBoxPhoneNumber.Name = "textBoxPhoneNumber";
            this.textBoxPhoneNumber.Size = new System.Drawing.Size(100, 20);
            this.textBoxPhoneNumber.TabIndex = 8;
            // 
            // textBoxNumberPanels
            // 
            this.textBoxNumberPanels.Location = new System.Drawing.Point(196, 89);
            this.textBoxNumberPanels.Name = "textBoxNumberPanels";
            this.textBoxNumberPanels.Size = new System.Drawing.Size(100, 20);
            this.textBoxNumberPanels.TabIndex = 9;
            // 
            // textBoxDeposit
            // 
            this.textBoxDeposit.Location = new System.Drawing.Point(196, 115);
            this.textBoxDeposit.Name = "textBoxDeposit";
            this.textBoxDeposit.Size = new System.Drawing.Size(100, 20);
            this.textBoxDeposit.TabIndex = 10;
            // 
            // buttonSubmit
            // 
            this.buttonSubmit.Location = new System.Drawing.Point(209, 142);
            this.buttonSubmit.Name = "buttonSubmit";
            this.buttonSubmit.Size = new System.Drawing.Size(87, 23);
            this.buttonSubmit.TabIndex = 11;
            this.buttonSubmit.Text = "Submit Order";
            this.buttonSubmit.UseVisualStyleBackColor = true;
            this.buttonSubmit.Click += new System.EventHandler(this.buttonSubmit_Click);
            // 
            // labelErrorFirstName
            // 
            this.labelErrorFirstName.AutoSize = true;
            this.labelErrorFirstName.ForeColor = System.Drawing.Color.Red;
            this.labelErrorFirstName.Location = new System.Drawing.Point(302, 15);
            this.labelErrorFirstName.Name = "labelErrorFirstName";
            this.labelErrorFirstName.Size = new System.Drawing.Size(0, 13);
            this.labelErrorFirstName.TabIndex = 12;
            // 
            // labelErrorLastName
            // 
            this.labelErrorLastName.AutoSize = true;
            this.labelErrorLastName.ForeColor = System.Drawing.Color.Red;
            this.labelErrorLastName.Location = new System.Drawing.Point(302, 41);
            this.labelErrorLastName.Name = "labelErrorLastName";
            this.labelErrorLastName.Size = new System.Drawing.Size(0, 13);
            this.labelErrorLastName.TabIndex = 13;
            // 
            // labelErrorPhoneNumber
            // 
            this.labelErrorPhoneNumber.AutoSize = true;
            this.labelErrorPhoneNumber.ForeColor = System.Drawing.Color.Red;
            this.labelErrorPhoneNumber.Location = new System.Drawing.Point(302, 67);
            this.labelErrorPhoneNumber.Name = "labelErrorPhoneNumber";
            this.labelErrorPhoneNumber.Size = new System.Drawing.Size(0, 13);
            this.labelErrorPhoneNumber.TabIndex = 14;
            // 
            // labelErrorNumberPanels
            // 
            this.labelErrorNumberPanels.AutoSize = true;
            this.labelErrorNumberPanels.ForeColor = System.Drawing.Color.Red;
            this.labelErrorNumberPanels.Location = new System.Drawing.Point(302, 92);
            this.labelErrorNumberPanels.Name = "labelErrorNumberPanels";
            this.labelErrorNumberPanels.Size = new System.Drawing.Size(0, 13);
            this.labelErrorNumberPanels.TabIndex = 15;
            // 
            // labelErrorDeposit
            // 
            this.labelErrorDeposit.AutoSize = true;
            this.labelErrorDeposit.ForeColor = System.Drawing.Color.Red;
            this.labelErrorDeposit.Location = new System.Drawing.Point(302, 118);
            this.labelErrorDeposit.Name = "labelErrorDeposit";
            this.labelErrorDeposit.Size = new System.Drawing.Size(0, 13);
            this.labelErrorDeposit.TabIndex = 16;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(584, 174);
            this.Controls.Add(this.labelErrorDeposit);
            this.Controls.Add(this.labelErrorNumberPanels);
            this.Controls.Add(this.labelErrorPhoneNumber);
            this.Controls.Add(this.labelErrorLastName);
            this.Controls.Add(this.labelErrorFirstName);
            this.Controls.Add(this.buttonSubmit);
            this.Controls.Add(this.textBoxDeposit);
            this.Controls.Add(this.textBoxNumberPanels);
            this.Controls.Add(this.textBoxPhoneNumber);
            this.Controls.Add(this.textBoxFirstName);
            this.Controls.Add(this.textBoxLastName);
            this.Controls.Add(this.checkBoxExpressInstall);
            this.Controls.Add(this.labelDeposit);
            this.Controls.Add(this.labelNumberPanels);
            this.Controls.Add(this.labelPhoneNumber);
            this.Controls.Add(this.labelLastName);
            this.Controls.Add(this.labelFirstName);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelFirstName;
        private System.Windows.Forms.Label labelLastName;
        private System.Windows.Forms.Label labelPhoneNumber;
        private System.Windows.Forms.Label labelNumberPanels;
        private System.Windows.Forms.Label labelDeposit;
        private System.Windows.Forms.CheckBox checkBoxExpressInstall;
        private System.Windows.Forms.TextBox textBoxLastName;
        private System.Windows.Forms.TextBox textBoxFirstName;
        private System.Windows.Forms.TextBox textBoxPhoneNumber;
        private System.Windows.Forms.TextBox textBoxNumberPanels;
        private System.Windows.Forms.TextBox textBoxDeposit;
        private System.Windows.Forms.Button buttonSubmit;
        private System.Windows.Forms.Label labelErrorFirstName;
        private System.Windows.Forms.Label labelErrorLastName;
        private System.Windows.Forms.Label labelErrorPhoneNumber;
        private System.Windows.Forms.Label labelErrorNumberPanels;
        private System.Windows.Forms.Label labelErrorDeposit;
    }
}

