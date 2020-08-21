namespace GamingArt
{
    partial class frmArt
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
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.Label art_IDLabel;
            System.Windows.Forms.Label art_TitleLabel;
            System.Windows.Forms.Label locationLabel;
            System.Windows.Forms.Label collectionLabel;
            System.Windows.Forms.Label retail_PriceLabel;
            System.Windows.Forms.Label artist_NameLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmArt));
            this.picArt = new System.Windows.Forms.PictureBox();
            this.lblTitle = new System.Windows.Forms.Label();
            this.artDataSet = new GamingArt.ArtDataSet();
            this.artistBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.artistTableAdapter = new GamingArt.ArtDataSetTableAdapters.ArtistTableAdapter();
            this.tableAdapterManager = new GamingArt.ArtDataSetTableAdapters.TableAdapterManager();
            this.artistBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.artistBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.art_IDTextBox = new System.Windows.Forms.TextBox();
            this.art_TitleTextBox = new System.Windows.Forms.TextBox();
            this.locationTextBox = new System.Windows.Forms.TextBox();
            this.collectionTextBox = new System.Windows.Forms.TextBox();
            this.retail_PriceTextBox = new System.Windows.Forms.TextBox();
            this.artist_NameComboBox = new System.Windows.Forms.ComboBox();
            this.btnValue = new System.Windows.Forms.Button();
            this.lblTotalRetailValue = new System.Windows.Forms.Label();
            art_IDLabel = new System.Windows.Forms.Label();
            art_TitleLabel = new System.Windows.Forms.Label();
            locationLabel = new System.Windows.Forms.Label();
            collectionLabel = new System.Windows.Forms.Label();
            retail_PriceLabel = new System.Windows.Forms.Label();
            artist_NameLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.picArt)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.artDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.artistBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.artistBindingNavigator)).BeginInit();
            this.artistBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // art_IDLabel
            // 
            art_IDLabel.AutoSize = true;
            art_IDLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            art_IDLabel.Location = new System.Drawing.Point(24, 198);
            art_IDLabel.Name = "art_IDLabel";
            art_IDLabel.Size = new System.Drawing.Size(50, 16);
            art_IDLabel.TabIndex = 3;
            art_IDLabel.Text = "Art ID:";
            // 
            // art_TitleLabel
            // 
            art_TitleLabel.AutoSize = true;
            art_TitleLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            art_TitleLabel.Location = new System.Drawing.Point(24, 247);
            art_TitleLabel.Name = "art_TitleLabel";
            art_TitleLabel.Size = new System.Drawing.Size(66, 16);
            art_TitleLabel.TabIndex = 7;
            art_TitleLabel.Text = "Art Title:";
            // 
            // locationLabel
            // 
            locationLabel.AutoSize = true;
            locationLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            locationLabel.Location = new System.Drawing.Point(326, 247);
            locationLabel.Name = "locationLabel";
            locationLabel.Size = new System.Drawing.Size(71, 16);
            locationLabel.TabIndex = 9;
            locationLabel.Text = "Location:";
            // 
            // collectionLabel
            // 
            collectionLabel.AutoSize = true;
            collectionLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            collectionLabel.Location = new System.Drawing.Point(24, 296);
            collectionLabel.Name = "collectionLabel";
            collectionLabel.Size = new System.Drawing.Size(81, 16);
            collectionLabel.TabIndex = 11;
            collectionLabel.Text = "Collection:";
            // 
            // retail_PriceLabel
            // 
            retail_PriceLabel.AutoSize = true;
            retail_PriceLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            retail_PriceLabel.Location = new System.Drawing.Point(326, 296);
            retail_PriceLabel.Name = "retail_PriceLabel";
            retail_PriceLabel.Size = new System.Drawing.Size(93, 16);
            retail_PriceLabel.TabIndex = 13;
            retail_PriceLabel.Text = "Retail Price:";
            // 
            // artist_NameLabel
            // 
            artist_NameLabel.AutoSize = true;
            artist_NameLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            artist_NameLabel.Location = new System.Drawing.Point(326, 198);
            artist_NameLabel.Name = "artist_NameLabel";
            artist_NameLabel.Size = new System.Drawing.Size(92, 16);
            artist_NameLabel.TabIndex = 5;
            artist_NameLabel.Text = "Artist Name:";
            // 
            // picArt
            // 
            this.picArt.Image = ((System.Drawing.Image)(resources.GetObject("picArt.Image")));
            this.picArt.Location = new System.Drawing.Point(12, 12);
            this.picArt.Name = "picArt";
            this.picArt.Size = new System.Drawing.Size(293, 160);
            this.picArt.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.picArt.TabIndex = 0;
            this.picArt.TabStop = false;
            // 
            // lblTitle
            // 
            this.lblTitle.Font = new System.Drawing.Font("Script MT Bold", 39.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTitle.ForeColor = System.Drawing.Color.Green;
            this.lblTitle.Location = new System.Drawing.Point(324, 25);
            this.lblTitle.Name = "lblTitle";
            this.lblTitle.Size = new System.Drawing.Size(318, 136);
            this.lblTitle.TabIndex = 1;
            this.lblTitle.Text = "Game Design Finalists";
            this.lblTitle.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // artDataSet
            // 
            this.artDataSet.DataSetName = "ArtDataSet";
            this.artDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // artistBindingSource
            // 
            this.artistBindingSource.DataMember = "Artist";
            this.artistBindingSource.DataSource = this.artDataSet;
            // 
            // artistTableAdapter
            // 
            this.artistTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.ArtistTableAdapter = this.artistTableAdapter;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.UpdateOrder = GamingArt.ArtDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // artistBindingNavigator
            // 
            this.artistBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.artistBindingNavigator.BindingSource = this.artistBindingSource;
            this.artistBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.artistBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.artistBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bindingNavigatorMoveFirstItem,
            this.bindingNavigatorMovePreviousItem,
            this.bindingNavigatorSeparator,
            this.bindingNavigatorPositionItem,
            this.bindingNavigatorCountItem,
            this.bindingNavigatorSeparator1,
            this.bindingNavigatorMoveNextItem,
            this.bindingNavigatorMoveLastItem,
            this.bindingNavigatorSeparator2,
            this.bindingNavigatorAddNewItem,
            this.bindingNavigatorDeleteItem,
            this.artistBindingNavigatorSaveItem});
            this.artistBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.artistBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.artistBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.artistBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.artistBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.artistBindingNavigator.Name = "artistBindingNavigator";
            this.artistBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.artistBindingNavigator.Size = new System.Drawing.Size(654, 25);
            this.artistBindingNavigator.TabIndex = 2;
            this.artistBindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorAddNewItem.Text = "Add new";
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(35, 22);
            this.bindingNavigatorCountItem.Text = "of {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Total number of items";
            // 
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorDeleteItem.Text = "Delete";
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveFirstItem.Text = "Move first";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMovePreviousItem.Text = "Move previous";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Position";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(50, 23);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Current position";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator1";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveNextItem.Text = "Move next";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveLastItem.Text = "Move last";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator2";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 25);
            // 
            // artistBindingNavigatorSaveItem
            // 
            this.artistBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.artistBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("artistBindingNavigatorSaveItem.Image")));
            this.artistBindingNavigatorSaveItem.Name = "artistBindingNavigatorSaveItem";
            this.artistBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.artistBindingNavigatorSaveItem.Text = "Save Data";
            this.artistBindingNavigatorSaveItem.Click += new System.EventHandler(this.artistBindingNavigatorSaveItem_Click);
            // 
            // art_IDTextBox
            // 
            this.art_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.artistBindingSource, "Art ID", true));
            this.art_IDTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.art_IDTextBox.Location = new System.Drawing.Point(114, 195);
            this.art_IDTextBox.Name = "art_IDTextBox";
            this.art_IDTextBox.Size = new System.Drawing.Size(49, 22);
            this.art_IDTextBox.TabIndex = 4;
            // 
            // art_TitleTextBox
            // 
            this.art_TitleTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.artistBindingSource, "Art Title", true));
            this.art_TitleTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.art_TitleTextBox.Location = new System.Drawing.Point(114, 244);
            this.art_TitleTextBox.Name = "art_TitleTextBox";
            this.art_TitleTextBox.Size = new System.Drawing.Size(195, 22);
            this.art_TitleTextBox.TabIndex = 8;
            // 
            // locationTextBox
            // 
            this.locationTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.artistBindingSource, "Location", true));
            this.locationTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.locationTextBox.Location = new System.Drawing.Point(429, 244);
            this.locationTextBox.Name = "locationTextBox";
            this.locationTextBox.Size = new System.Drawing.Size(195, 22);
            this.locationTextBox.TabIndex = 10;
            // 
            // collectionTextBox
            // 
            this.collectionTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.artistBindingSource, "Collection", true));
            this.collectionTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.collectionTextBox.Location = new System.Drawing.Point(114, 293);
            this.collectionTextBox.Name = "collectionTextBox";
            this.collectionTextBox.Size = new System.Drawing.Size(195, 22);
            this.collectionTextBox.TabIndex = 12;
            // 
            // retail_PriceTextBox
            // 
            this.retail_PriceTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.artistBindingSource, "Retail Price", true));
            this.retail_PriceTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.retail_PriceTextBox.Location = new System.Drawing.Point(429, 293);
            this.retail_PriceTextBox.Name = "retail_PriceTextBox";
            this.retail_PriceTextBox.Size = new System.Drawing.Size(80, 22);
            this.retail_PriceTextBox.TabIndex = 14;
            // 
            // artist_NameComboBox
            // 
            this.artist_NameComboBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.artistBindingSource, "Artist Name", true));
            this.artist_NameComboBox.DataSource = this.artistBindingSource;
            this.artist_NameComboBox.DisplayMember = "Artist Name";
            this.artist_NameComboBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.artist_NameComboBox.FormattingEnabled = true;
            this.artist_NameComboBox.Location = new System.Drawing.Point(429, 195);
            this.artist_NameComboBox.Name = "artist_NameComboBox";
            this.artist_NameComboBox.Size = new System.Drawing.Size(195, 24);
            this.artist_NameComboBox.TabIndex = 6;
            this.artist_NameComboBox.ValueMember = "Artist Name";
            // 
            // btnValue
            // 
            this.btnValue.AutoSize = true;
            this.btnValue.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnValue.ForeColor = System.Drawing.Color.Green;
            this.btnValue.Location = new System.Drawing.Point(246, 330);
            this.btnValue.Name = "btnValue";
            this.btnValue.Size = new System.Drawing.Size(178, 30);
            this.btnValue.TabIndex = 15;
            this.btnValue.Text = "Total Retail Value";
            this.btnValue.UseVisualStyleBackColor = true;
            this.btnValue.Click += new System.EventHandler(this.btnValue_Click);
            // 
            // lblTotalRetailValue
            // 
            this.lblTotalRetailValue.AutoSize = true;
            this.lblTotalRetailValue.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTotalRetailValue.Location = new System.Drawing.Point(204, 375);
            this.lblTotalRetailValue.Name = "lblTotalRetailValue";
            this.lblTotalRetailValue.Size = new System.Drawing.Size(262, 20);
            this.lblTotalRetailValue.TabIndex = 0;
            this.lblTotalRetailValue.Text = "XXXXXXXXXXXXXXXXXXXXXXX";
            this.lblTotalRetailValue.Visible = false;
            // 
            // frmArt
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(654, 411);
            this.Controls.Add(this.lblTotalRetailValue);
            this.Controls.Add(this.btnValue);
            this.Controls.Add(artist_NameLabel);
            this.Controls.Add(this.artist_NameComboBox);
            this.Controls.Add(retail_PriceLabel);
            this.Controls.Add(this.retail_PriceTextBox);
            this.Controls.Add(collectionLabel);
            this.Controls.Add(this.collectionTextBox);
            this.Controls.Add(locationLabel);
            this.Controls.Add(this.locationTextBox);
            this.Controls.Add(art_TitleLabel);
            this.Controls.Add(this.art_TitleTextBox);
            this.Controls.Add(art_IDLabel);
            this.Controls.Add(this.art_IDTextBox);
            this.Controls.Add(this.artistBindingNavigator);
            this.Controls.Add(this.lblTitle);
            this.Controls.Add(this.picArt);
            this.Name = "frmArt";
            this.Text = "Gaming Art Commission - Game Art & Design Competition";
            this.Load += new System.EventHandler(this.frmArt_Load);
            ((System.ComponentModel.ISupportInitialize)(this.picArt)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.artDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.artistBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.artistBindingNavigator)).EndInit();
            this.artistBindingNavigator.ResumeLayout(false);
            this.artistBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox picArt;
        private System.Windows.Forms.Label lblTitle;
        private ArtDataSet artDataSet;
        private System.Windows.Forms.BindingSource artistBindingSource;
        private ArtDataSetTableAdapters.ArtistTableAdapter artistTableAdapter;
        private ArtDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator artistBindingNavigator;
        private System.Windows.Forms.ToolStripButton bindingNavigatorAddNewItem;
        private System.Windows.Forms.ToolStripLabel bindingNavigatorCountItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorDeleteItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveFirstItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMovePreviousItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator;
        private System.Windows.Forms.ToolStripTextBox bindingNavigatorPositionItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator1;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveNextItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveLastItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator2;
        private System.Windows.Forms.ToolStripButton artistBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox art_IDTextBox;
        private System.Windows.Forms.TextBox art_TitleTextBox;
        private System.Windows.Forms.TextBox locationTextBox;
        private System.Windows.Forms.TextBox collectionTextBox;
        private System.Windows.Forms.TextBox retail_PriceTextBox;
        private System.Windows.Forms.ComboBox artist_NameComboBox;
        private System.Windows.Forms.Button btnValue;
        private System.Windows.Forms.Label lblTotalRetailValue;
    }
}

