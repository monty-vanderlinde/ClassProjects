namespace Assignment2CSharp
{
    partial class Form2
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
            this.buttonClose = new System.Windows.Forms.Button();
            this.labelName = new System.Windows.Forms.Label();
            this.buttonEditOrder = new System.Windows.Forms.Button();
            this.buttonNewOrder = new System.Windows.Forms.Button();
            this.labelPhone = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.labelAdditionalPanels = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.labelRefund = new System.Windows.Forms.Label();
            this.labelBaseCost = new System.Windows.Forms.Label();
            this.labelAdditionalCost = new System.Windows.Forms.Label();
            this.labelTotalCost = new System.Windows.Forms.Label();
            this.labelDeposit = new System.Windows.Forms.Label();
            this.labelBalanceDue = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // buttonClose
            // 
            this.buttonClose.Location = new System.Drawing.Point(386, 199);
            this.buttonClose.Name = "buttonClose";
            this.buttonClose.Size = new System.Drawing.Size(75, 23);
            this.buttonClose.TabIndex = 0;
            this.buttonClose.Text = "Close";
            this.buttonClose.UseVisualStyleBackColor = true;
            this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
            // 
            // labelName
            // 
            this.labelName.AutoSize = true;
            this.labelName.Location = new System.Drawing.Point(12, 15);
            this.labelName.Name = "labelName";
            this.labelName.Size = new System.Drawing.Size(29, 13);
            this.labelName.TabIndex = 1;
            this.labelName.Text = "label";
            // 
            // buttonEditOrder
            // 
            this.buttonEditOrder.Location = new System.Drawing.Point(206, 199);
            this.buttonEditOrder.Name = "buttonEditOrder";
            this.buttonEditOrder.Size = new System.Drawing.Size(75, 23);
            this.buttonEditOrder.TabIndex = 2;
            this.buttonEditOrder.Text = "Edit Order";
            this.buttonEditOrder.UseVisualStyleBackColor = true;
            this.buttonEditOrder.Click += new System.EventHandler(this.buttonEditOrder_Click);
            // 
            // buttonNewOrder
            // 
            this.buttonNewOrder.Location = new System.Drawing.Point(12, 199);
            this.buttonNewOrder.Name = "buttonNewOrder";
            this.buttonNewOrder.Size = new System.Drawing.Size(75, 23);
            this.buttonNewOrder.TabIndex = 3;
            this.buttonNewOrder.Text = "New Order";
            this.buttonNewOrder.UseVisualStyleBackColor = true;
            this.buttonNewOrder.Click += new System.EventHandler(this.buttonNewOrder_Click);
            // 
            // labelPhone
            // 
            this.labelPhone.AutoSize = true;
            this.labelPhone.Location = new System.Drawing.Point(12, 41);
            this.labelPhone.Name = "labelPhone";
            this.labelPhone.Size = new System.Drawing.Size(29, 13);
            this.labelPhone.TabIndex = 4;
            this.labelPhone.Text = "label";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 67);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(120, 13);
            this.label1.TabIndex = 7;
            this.label1.Text = "Base Charge (2 panels):";
            // 
            // labelAdditionalPanels
            // 
            this.labelAdditionalPanels.AutoSize = true;
            this.labelAdditionalPanels.Location = new System.Drawing.Point(12, 93);
            this.labelAdditionalPanels.Name = "labelAdditionalPanels";
            this.labelAdditionalPanels.Size = new System.Drawing.Size(29, 13);
            this.labelAdditionalPanels.TabIndex = 8;
            this.labelAdditionalPanels.Text = "label";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 119);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(58, 13);
            this.label3.TabIndex = 9;
            this.label3.Text = "Total Cost:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(12, 145);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(85, 13);
            this.label4.TabIndex = 10;
            this.label4.Text = "Deposit Amount:";
            // 
            // labelRefund
            // 
            this.labelRefund.AutoSize = true;
            this.labelRefund.Location = new System.Drawing.Point(12, 171);
            this.labelRefund.Name = "labelRefund";
            this.labelRefund.Size = new System.Drawing.Size(72, 13);
            this.labelRefund.TabIndex = 11;
            this.labelRefund.Text = "Balance Due:";
            // 
            // labelBaseCost
            // 
            this.labelBaseCost.AutoSize = true;
            this.labelBaseCost.BackColor = System.Drawing.SystemColors.Control;
            this.labelBaseCost.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.labelBaseCost.Location = new System.Drawing.Point(160, 67);
            this.labelBaseCost.Name = "labelBaseCost";
            this.labelBaseCost.Size = new System.Drawing.Size(31, 15);
            this.labelBaseCost.TabIndex = 12;
            this.labelBaseCost.Text = "label";
            // 
            // labelAdditionalCost
            // 
            this.labelAdditionalCost.AutoSize = true;
            this.labelAdditionalCost.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.labelAdditionalCost.Location = new System.Drawing.Point(160, 93);
            this.labelAdditionalCost.Name = "labelAdditionalCost";
            this.labelAdditionalCost.Size = new System.Drawing.Size(31, 15);
            this.labelAdditionalCost.TabIndex = 13;
            this.labelAdditionalCost.Text = "label";
            // 
            // labelTotalCost
            // 
            this.labelTotalCost.AutoSize = true;
            this.labelTotalCost.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.labelTotalCost.Location = new System.Drawing.Point(160, 119);
            this.labelTotalCost.Name = "labelTotalCost";
            this.labelTotalCost.Size = new System.Drawing.Size(31, 15);
            this.labelTotalCost.TabIndex = 14;
            this.labelTotalCost.Text = "label";
            // 
            // labelDeposit
            // 
            this.labelDeposit.AutoSize = true;
            this.labelDeposit.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.labelDeposit.Location = new System.Drawing.Point(160, 145);
            this.labelDeposit.Name = "labelDeposit";
            this.labelDeposit.Size = new System.Drawing.Size(31, 15);
            this.labelDeposit.TabIndex = 15;
            this.labelDeposit.Text = "label";
            // 
            // labelBalanceDue
            // 
            this.labelBalanceDue.AutoSize = true;
            this.labelBalanceDue.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.labelBalanceDue.Location = new System.Drawing.Point(160, 171);
            this.labelBalanceDue.Name = "labelBalanceDue";
            this.labelBalanceDue.Size = new System.Drawing.Size(31, 15);
            this.labelBalanceDue.TabIndex = 16;
            this.labelBalanceDue.Text = "label";
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(473, 234);
            this.Controls.Add(this.labelBalanceDue);
            this.Controls.Add(this.labelDeposit);
            this.Controls.Add(this.labelTotalCost);
            this.Controls.Add(this.labelAdditionalCost);
            this.Controls.Add(this.labelBaseCost);
            this.Controls.Add(this.labelRefund);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.labelAdditionalPanels);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.labelPhone);
            this.Controls.Add(this.buttonNewOrder);
            this.Controls.Add(this.buttonEditOrder);
            this.Controls.Add(this.labelName);
            this.Controls.Add(this.buttonClose);
            this.Name = "Form2";
            this.Text = "Form2";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button buttonClose;
        private System.Windows.Forms.Label labelName;
        private System.Windows.Forms.Button buttonEditOrder;
        private System.Windows.Forms.Button buttonNewOrder;
        private System.Windows.Forms.Label labelPhone;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label labelAdditionalPanels;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label labelRefund;
        private System.Windows.Forms.Label labelBaseCost;
        private System.Windows.Forms.Label labelAdditionalCost;
        private System.Windows.Forms.Label labelTotalCost;
        private System.Windows.Forms.Label labelDeposit;
        private System.Windows.Forms.Label labelBalanceDue;
    }
}