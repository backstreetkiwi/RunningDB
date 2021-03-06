package de.zaunkoenigweg.runningdb.vaadin.ui;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.MouseEvents;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.Align;

import de.zaunkoenigweg.runningdb.model.ShoeStatistics;

/**
 * UI to manage runnint shoes.
 * 
 * @author Nikolaus Winter
 */
public class ShoeUi extends AbstractUi {

    private static final long serialVersionUID = 23250312284950498L;

    private Table tableShoes;
    private BeanItemContainer<ShoeStatistics> shoeContainer;

    private static final DistanceConverter DISTANCE_CONVERTER = new DistanceConverter();

    /**
     * Create ShoeUI.
     */
    public ShoeUi() {
        
        Layout layout = new FormLayout();
        setCompositionRoot(layout);

        // container for all shoes 
        shoeContainer = new BeanItemContainer<ShoeStatistics>(ShoeStatistics.class);
        
        // table showing all shoes
        tableShoes = new Table("", shoeContainer);
        layout.addComponent(tableShoes);
        tableShoes.setColumnHeader("info", "");
        tableShoes.setColumnHeader("date", "Jahr");
        tableShoes.setColumnHeader("brand", "Hersteller");
        tableShoes.setColumnHeader("model", "Modell");
        tableShoes.setColumnHeader("distance", "Strecke");
        tableShoes.setColumnHeader("active", "aktiv?");
        tableShoes.setPageLength(15);
        tableShoes.setWidth("560px");
        tableShoes.setColumnWidth("info", 40);
        tableShoes.setColumnWidth("date", 40);
        tableShoes.setColumnWidth("brand", 100);
        tableShoes.setColumnWidth("model", 150);
        tableShoes.setColumnWidth("distance", 75);
        tableShoes.setColumnWidth("active", 75);
        tableShoes.setConverter("distance", DISTANCE_CONVERTER);
        tableShoes.setColumnAlignment("info", Align.CENTER);
        tableShoes.setColumnAlignment("distance", Align.RIGHT);
        tableShoes.setColumnAlignment("active", Align.CENTER);

        tableShoes.addGeneratedColumn("info", new Table.ColumnGenerator() {
            
            private static final long serialVersionUID = -2108447767546846249L;

            @Override
            public Object generateCell(Table source, Object itemId, Object columnId) {
                final ShoeStatistics shoeInfo = (ShoeStatistics)itemId;
                Image image = new Image("", new ThemeResource("icons/zoom2.png"));
                image.addClickListener(new MouseEvents.ClickListener() {
                    
                    private static final long serialVersionUID = -2017287667521809493L;

                    @Override
                    public void click(ClickEvent event) {
                        ShoeInfoTooltip.show(shoeInfo, event.getClientX(), event.getClientY());
                    }
                });
                return image;
            }
        });

        tableShoes.addGeneratedColumn("date", new Table.ColumnGenerator() {
            
            private static final long serialVersionUID = -2108447767546846249L;
            
            @Override
            public Object generateCell(Table source, Object itemId, Object columnId) {
            	ShoeStatistics shoeInfo = (ShoeStatistics)itemId;
                return new Label(shoeInfo.getShoe().getDateOfPurchase());
            }
        });
        
        tableShoes.addGeneratedColumn("brand", new Table.ColumnGenerator() {
            
            private static final long serialVersionUID = -2108447767546846249L;
            
            @Override
            public Object generateCell(Table source, Object itemId, Object columnId) {
            	ShoeStatistics shoeInfo = (ShoeStatistics)itemId;
                return new Label(shoeInfo.getShoe().getBrand());
            }
        });
        
        tableShoes.addGeneratedColumn("model", new Table.ColumnGenerator() {
            
            private static final long serialVersionUID = -1734531230843770477L;

            @Override
            public Object generateCell(Table source, Object itemId, Object columnId) {
            	ShoeStatistics shoeInfo = (ShoeStatistics)itemId;
                return new Label(shoeInfo.getShoe().getModel());
            }
        });

        tableShoes.addGeneratedColumn("active", new Table.ColumnGenerator() {
            
            private static final long serialVersionUID = -1734531230843770477L;
            
            @Override
            public Object generateCell(Table source, Object itemId, Object columnId) {
            	ShoeStatistics shoeInfo = (ShoeStatistics)itemId;
                return new Label(shoeInfo.getShoe().isActive() ? "ja" : "nein");
            }
        });
        
        tableShoes.setVisibleColumns(new Object[] {"info", "date", "brand", "model", "distance", "active"});
        
        tableShoes.setPageLength(this.shoeContainer.size());
        
    }

    @Override
    public void show() {
        // retrieve list w/ shoe information from training log and show it
        this.shoeContainer.removeAllItems();
        this.shoeContainer.addAll(getTrainingLog().getShoeStatistics());
    }

}
