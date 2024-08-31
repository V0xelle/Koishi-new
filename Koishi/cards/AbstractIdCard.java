/*     */ package Koishi.cards;
/*     */ 
/*     */ import Koishi.actions.PlayIdCardAction;
/*     */ import Koishi.cards.Attacks.Common.SubconsciousSweep;
/*     */ import Koishi.cards.Attacks.Uncommon.HeartAttack;
/*     */ import Koishi.cards.Skills.Common.SubterraneanRose;
/*     */ import Koishi.cards.Skills.Common.UnconsciousUprising;
/*     */ import Koishi.cards.Skills.Rare.FadingMemory;
/*     */ import Koishi.cards.Skills.Uncommon.IdleWhim;
/*     */ import Koishi.cards.Skills.Uncommon.MassHysteria;
/*     */ import Koishi.cards.Skills.Uncommon.RorschachInDanmaku;
/*     */ import Koishi.cards.Skills.Uncommon.SprinkleStarAndHeart;
/*     */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*     */ import com.megacrit.cardcrawl.blights.AbstractBlight;
/*     */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*     */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*     */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*     */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*     */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*     */ import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public abstract class AbstractIdCard
/*     */   extends AbstractDefaultCard {
/*  26 */   public static int idCardsDrawn = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean drewIdCardThisTurn = false;
/*     */ 
/*     */   
/*     */   public static boolean idEnabled = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractIdCard(String id, String img, int cost, AbstractCard.CardType type, AbstractCard.CardColor color, AbstractCard.CardRarity rarity, AbstractCard.CardTarget target) {
/*  38 */     super(id, img, cost, type, color, rarity, target);
/*     */   }
/*     */ 
/*     */   
/*     */   public void triggerWhenDrawn() {
/*  43 */     if (idEnabled) {
/*  44 */       if (!this.freeToPlayOnce) {
/*  45 */         if (EnergyPanel.getCurrentEnergy() > 0 && canPlayDisregardingEnergy()) {
/*  46 */           AbstractDungeon.player.energy.use(this.costForTurn);
/*     */         }
/*     */       } else {
/*  49 */         this.freeToPlayOnce = false;
/*     */       } 
/*  51 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new PlayIdCardAction((AbstractCard)this, (AbstractCreature)(AbstractDungeon.getCurrRoom()).monsters.getRandomMonster(null, true, AbstractDungeon.cardRandomRng), false));
/*     */     } 
/*  53 */     idCardsDrawn++;
/*  54 */     drewIdCardThisTurn = true;
/*     */   }
/*     */   public boolean canPlayDisregardingEnergy() {
/*     */     AbstractPower p;
/*  58 */     if (AbstractDungeon.actionManager.turnHasEnded) {
/*  59 */       return false;
/*     */     }
/*  61 */     Iterator<AbstractCard> var1 = AbstractDungeon.player.powers.iterator();
/*     */ 
/*     */     
/*     */     do {
/*  65 */       if (!var1.hasNext()) {
/*  66 */         AbstractRelic r; if (AbstractDungeon.player.hasPower("Entangled") && this.type == AbstractCard.CardType.ATTACK) {
/*  67 */           return false;
/*     */         }
/*     */         
/*  70 */         var1 = AbstractDungeon.player.relics.iterator();
/*     */ 
/*     */         
/*     */         do {
/*  74 */           if (!var1.hasNext()) {
/*  75 */             AbstractBlight b; var1 = AbstractDungeon.player.blights.iterator();
/*     */ 
/*     */             
/*     */             do {
/*  79 */               if (!var1.hasNext()) {
/*  80 */                 AbstractCard c; var1 = AbstractDungeon.player.hand.group.iterator();
/*     */ 
/*     */                 
/*     */                 do {
/*  84 */                   if (!var1.hasNext()) {
/*  85 */                     return true;
/*     */                   }
/*     */                   
/*  88 */                   c = var1.next();
/*  89 */                 } while (c.canPlay((AbstractCard)this));
/*     */                 
/*  91 */                 return false;
/*     */               } 
/*     */               
/*  94 */               b = (AbstractBlight)var1.next();
/*  95 */             } while (b.canPlay((AbstractCard)this));
/*     */             
/*  97 */             return false;
/*     */           } 
/*     */           
/* 100 */           r = (AbstractRelic)var1.next();
/* 101 */         } while (r.canPlay((AbstractCard)this));
/*     */         
/* 103 */         return false;
/*     */       } 
/*     */       
/* 106 */       p = (AbstractPower)var1.next();
/* 107 */     } while (p.canPlayCard((AbstractCard)this));
/*     */     
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static AbstractIdCard returnTrulyRandomIdCard() {
/* 114 */     ArrayList<AbstractCard> list = new ArrayList<>();
/* 115 */     list.add(new SubconsciousSweep());
/* 116 */     list.add(new UnconsciousUprising());
/* 117 */     list.add(new SprinkleStarAndHeart());
/* 118 */     list.add(new SubterraneanRose());
/* 119 */     list.add(new IdleWhim());
/*     */     
/* 121 */     list.add(new RorschachInDanmaku());
/* 122 */     list.add(new HeartAttack());
/* 123 */     list.add(new MassHysteria());
/*     */     
/* 125 */     list.add(new FadingMemory());
/*     */     
/* 127 */     return (AbstractIdCard)list.get(AbstractDungeon.cardRandomRng.random(list.size() - 1));
/*     */   }
/*     */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/AbstractIdCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */